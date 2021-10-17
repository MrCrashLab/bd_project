package test;

import test.Models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import test.Requests.FullApplicationClient;
import test.Requests.FullApplicationLegal;
import test.Requests.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BankSystem {
    private List<FullApplicationClient> fullApplicationClients = new ArrayList<FullApplicationClient>();
    private List<FullApplicationLegal> fullApplicationLegals = new ArrayList<FullApplicationLegal>();
    private Login login;
    public BankSystem() {
    }

    public List<FullApplicationClient> getFullApplicationClients() {
        return fullApplicationClients;
    }

    public List<FullApplicationLegal> getFullApplicationLegals() {
        return fullApplicationLegals;
    }

    public Login getLogin() {
        return login;
    }

    @Value("${jdbc_url}")
    @JsonIgnore
    private String jdbcUrl;

    @Value("${psgr_lg}")
    @JsonIgnore
    private String psgr_lg;

    @Value("${psgr_pw}")
    @JsonIgnore
    private String psgr_pw;

    public void getFullApplicationClient(String name, String pass) {
        fullApplicationClients.clear();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, psgr_lg, psgr_pw);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT \"Application\".\"ApplicationNum\", \"Application\".\"Stage\"," +
                    "\"Application\".\"Source\", \"Application\".\"Region\",\n" +
                    "\"Application\".\"Branch\", \"Application\".\"DateCreation\", \"Application\".\"Priority\",\n" +
                    "\"ApplicationAggr\".\"Type\" as \"TypeApAg\", \"ApplicationAggr\".\"Number\" as \"NumberApAg\", \n" +
                    "\"ApplicationAggr\".\"TotalLimit\", \"ApplicationAggr\".\"TotalPayment\", \"ApplicationAggr\".\"LimitProductCategory\",\n" +
                    "\"ApplicationAggr\".\"LimitProductName\", \"ApplicationAggr\".\"LastDateCreated\", \"ApplicationAggr\".\"LastDateFunded\",\n" +
                    "\"ApplicationList\".\"PrimaryKey\" as \"PrimaryApList\", \"ApplicationList\".\"StageID\", \"ApplicationList\".\"ProductCategory\",\n" +
                    "\"ApplicationList\".\"ProductID\", \"ApplicationList\".\"ProductName\",\n" +
                    "\"ApplicationList\".\"MarketingSegment\", \"ApplicationList\".\"ParticipationType\", \"ApplicationList\".\"Limit\",\n" +
                    "\"ApplicationList\".\"Payment\", \"ApplicationList\".\"DateCreation\", \"ApplicationList\".\"DateApproved\",\n" +
                    "\"ApplicationList\".\"Status\", \"ApplicationList\".\"OpenDate\", \"ApplicationList\".\"FinishDate\",\n" +
                    "\"Client\".\"BirthDate\", \"Client\".\"BirthPlace\",\n" +
                    "\"Client\".\"Age\", \"Client\".\"Gender\", \"Client\".\"Citizenship\", \"Client\".\"Education\",\n" +
                    "\"Client\".\"Surname\" as \"SurnameClient\", \"Client\".\"Name\" as \"NameClient\", \"Client\".\"Patronymic\", \"Client\".\"DocumentType\",\n" +
                    "\"Client\".\"Passportnum\", \"Client\".\"Issuedate\" as \"IssuedateClient\", \"Client\".\"IssuePlace\",\n" +
                    "\"Client\".\"IssueAuthority\", \"Client\".\"Departmentcode\", \"Client\".\"SNILS\",\n" +
                    "\"Credit\".\"Index\", \"Credit\".\"Type\" as \"TypeCredit\", \"Credit\".\"PrimaryKey\" as \"PrimaryKeyCredit\",\n" +
                    "\"Credit\".\"ContractRef\", \"Credit\".\"Currency\", \"Credit\".\"IssueDate\" as \"IssueDateCredit\",\n" +
                    "\"Credit\".\"Annuity\", \"Credit\".\"Product\", \"Credit\".\"Comment\",\n" +
                    "\"Declined\".\"LastDate\",\n" +
                    "\"Employees\".\"NAME\" as \"NameEmployees\", \"Employees\".\"SURNAME\" as \"SurnameEmployees\", \"Employees\".\"RANG\",\n" +
                    "\"Income\".\"Type\" as \"TypeIncome\", \"Income\".\"Main\",\n" +
                    "\"Income\".\"Confirmation\", \"Income\".\"Periodicity\", \"Income\".\"PaymentManner\",\n" +
                    "\"Income\".\"Currency\", \"Income\".\"Value\", \"Income\".\"Average\",\n" +
                    "\"Loan\".\"Type\" as \"TypeLoan\", \"Loan\".\"Status\",\n" +
                    "\"Loan\".\"Annuity\", \"Loan\".\"InitialAmount\", \"Loan\".\"Outstanding\",\n" +
                    "\"Loan\".\"PaidInterest\", \"Loan\".\"PledgeValue\",\n" +
                    "\"Loan\".\"DateFunded\", \"Loan\".\"DateRealClose\",\n" +
                    "\"ProductDeclined\".\"Type\" as \"TypeProductDeclined\", \"ProductDeclined\".\"Number\" as \"NumberProductDeclined\",\n" +
                    "\"ProductParameters\".\"ProductCategory\", \"ProductParameters\".\"ProductName\",\n" +
                    "\"ProductParameters\".\"Purpose\", \"ProductParameters\".\"DisbursementDate\",\n" +
                    "\"ProductParameters\".\"RepaymentScheme\", \"ProductParameters\".\"FirstPaymentDate\",\n" +
                    "\"ProductParameters\".\"RepaymentDate\", \"ProductParameters\".\"DownPaymentSource\",\n" +
                    "\"ProductParameters\".\"DelayPeriod\", \"ProductParameters\".\"RefSum\"\n" +
                    "FROM \"Application\"\n" +
                    "inner join \"Participant\" on \"Participant\".\"PARENTID\"=\"Application\".\"ID\"\n" +
                    "inner join \"Terms\" ON \"Terms\".\"PARENTID\"=\"Application\".\"ID\"\n" +
                    "inner join \"ProductParameters\" ON \"ProductParameters\".\"PARENTID\"=\"Terms\".\"ID\"\n" +
                    "inner join \"Loan\" ON \"Loan\".\"PARENTID\"=\"ProductParameters\".\"ID\"\n" +
                    "inner join \"Finances\" ON \"Finances\".\"PARENTID\"=\"Participant\".\"ID\"\n" +
                    "inner join \"Income\" ON \"Income\".\"PARENTID\"=\"Finances\".\"ID\"\n" +
                    "inner join \"Credit\" ON \"Credit\".\"PARENTID\"=\"Finances\".\"ID\"\n" +
                    "inner join \"Employees\" ON \"Employees\".\"PARENTID\"=\"Participant\".\"ID\"\n" +
                    "inner join \"Client\" ON \"Client\".\"PARENTID\"=\"Participant\".\"ID\"\n" +
                    "inner join \"HistoryApplicationList\" ON \"HistoryApplicationList\".\"PARENTID\"=\"Participant\".\"ID\"\n" +
                    "inner join \"ApplicationList\" ON \"ApplicationList\".\"PARENTID\"=\"HistoryApplicationList\".\"ID\"\n" +
                    "inner join \"ApplicationAggr\" ON \"ApplicationAggr\".\"PARENTID\"=\"HistoryApplicationList\".\"ID\"\n" +
                    "inner join \"Declined\" ON \"Declined\".\"PARENTID\"=\"HistoryApplicationList\".\"ID\"\n" +
                    "inner join \"ProductDeclined\" on \"ProductDeclined\".\"PARENTID\"=\"Declined\".\"ID\" where \"Client\".\"Name\"=? and \"Client\".\"Passportnum\"=?;");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                ApplicationAggr applicationAggr = new ApplicationAggr(result.getString("TypeApAg"),
                        result.getInt("NumberApAg"),
                        result.getInt("TotalLimit"),
                        result.getInt("TotalPayment"),
                        result.getInt("LimitProductCategory"),
                        result.getInt("LimitProductName"),
                        result.getDate("LastDateCreated"),
                        result.getDate("LastDateFunded")
                );
                ApplicationList applicationList = new ApplicationList(result.getString("PrimaryApList"),
                        result.getString("StageID"),
                        result.getString("ProductCategory"),
                        result.getString("ProductID"),
                        result.getString("ProductName"),
                        result.getString("MarketingSegment"),
                        result.getString("ParticipationType"),
                        result.getInt("Limit"),
                        result.getInt("Payment"),
                        result.getDate("DateCreation"),
                        result.getDate("DateApproved"),
                        result.getString("Status"),
                        result.getDate("OpenDate"),
                        result.getDate("FinishDate")
                );
                Application application = new Application(result.getString("ApplicationNum"),
                        result.getString("Stage"),
                        result.getString("Source"),
                        result.getString("Region"),
                        result.getString("Branch"),
                        result.getDate("DateCreation"),
                        result.getString("Priority")
                );
                Client client = new Client(result.getDate("BirthDate"),
                        result.getString("BirthPlace"),
                        result.getInt("Age"),
                        result.getString("Gender"),
                        result.getString("Citizenship"),
                        result.getString("Education"),
                        result.getString("SurnameClient"),
                        result.getString("NameClient"),
                        result.getString("Patronymic"),
                        result.getString("DocumentType"),
                        result.getString("Passportnum"),
                        result.getDate("IssuedateClient"),
                        result.getString("IssuePlace"),
                        result.getString("IssueAuthority"),
                        result.getString("Departmentcode"),
                        result.getString("SNILS")
                );
                Credit credit = new Credit(result.getString("Index"),
                        result.getString("TypeCredit"),
                        result.getString("PrimaryKeyCredit"),
                        result.getString("ContractRef"),
                        result.getString("Currency"),
                        result.getDate("IssueDateCredit"),
                        result.getString("Annuity"),
                        result.getString("Product"),
                        result.getString("DateCreation")
                );
                Declined declined = new Declined(result.getDate("LastDate")
                );
                Employess employess = new Employess(result.getString("NameEmployees"),
                        result.getString("SurnameEmployees"),
                        result.getString("RANG")
                );
                Income income = new Income(result.getString("TypeIncome"),
                        result.getString("Main"),
                        result.getString("Confirmation"),
                        result.getString("Periodicity"),
                        result.getString("PaymentManner"),
                        result.getString("Currency"),
                        result.getString("Value"),
                        result.getString("Average")
                );
                Loan loan = new Loan(result.getString("TypeLoan"),
                        result.getString("Status"),
                        result.getInt("Annuity"),
                        result.getInt("InitialAmount"),
                        result.getInt("Outstanding"),
                        result.getInt("PaidInterest"),
                        result.getInt("PledgeValue"),
                        result.getDate("DateFunded"),
                        result.getDate("DateRealClose")
                );
                ProductDeclined productDeclined = new ProductDeclined(result.getString("TypeProductDeclined"),
                        result.getInt("NumberProductDeclined")
                );
                ProductParameters productParameters = new ProductParameters(result.getString("ProductCategory"),
                        result.getString("ProductName"),
                        result.getString("Purpose"),
                        result.getDate("DisbursementDate"),
                        result.getString("RepaymentScheme"),
                        result.getDate("FirstPaymentDate"),
                        result.getDate("RepaymentDate"),
                        result.getString("DownPaymentSource"),
                        result.getInt("DelayPeriod"),
                        result.getInt("RefSum")
                );

                fullApplicationClients.add(new FullApplicationClient(application, applicationAggr, applicationList, client, credit, declined, employess, income,
                        loan, productDeclined, productParameters));
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void loginClient(String name, String pass)
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, psgr_lg, psgr_pw);
            PreparedStatement preparedStatement = connection.prepareStatement("select case\n" +
                    "when (select COUNT(*) from \"Client\" where \"Name\"=? and \"Passportnum\"=?) > 0 then 'true'\n" +
                    "else 'false'\n" +
                    "end result;");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                login = new Login(result.getString("result"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void postApplication(FullApplicationClient fullApplicationClient)
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(jdbcUrl, psgr_lg, psgr_pw);
            PreparedStatement st = c.prepareStatement("INSERT INTO \"Application\"\n" +
                    "(\"ApplicationNum\", \"Stage\", \"Source\", \"Region\", \"Branch\", \"DateCreation\", \"Priority\")\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, fullApplicationClient.getApplication().getApplicationNum());
            st.setString(2, fullApplicationClient.getApplication().getStage());
            st.setString(3, fullApplicationClient.getApplication().getSource());
            st.setString(4, fullApplicationClient.getApplication().getRegion());
            st.setString(5, fullApplicationClient.getApplication().getBranch());
            st.setDate(6, fullApplicationClient.getApplication().getDateCreation());
            st.setString(7, fullApplicationClient.getApplication().getPriority());
            st.execute();
            st = c.prepareStatement("insert into \"Terms\" DEFAULT VALUES;");
            st.execute();
            st = c.prepareStatement("INSERT INTO \"ProductParameters\"\n" +
                    "(\"ProductCategory\", \"ProductName\", \"Purpose\", \"DisbursementDate\"," +
                    "\"RepaymentScheme\", \"FirstPaymentDate\", \"RepaymentDate\"," +
                    "\"DownPaymentSource\", \"DelayPeriod\", \"RefSum\")\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, fullApplicationClient.getProductParameters().getProductCategory());
            st.setString(2, fullApplicationClient.getProductParameters().getProductName());
            st.setString(3, fullApplicationClient.getProductParameters().getPurpose());
            st.setDate(4, fullApplicationClient.getProductParameters().getDisbursementDate());
            st.setString(5, fullApplicationClient.getProductParameters().getRepaymentScheme());
            st.setDate(6, fullApplicationClient.getProductParameters().getFirstPaymentDate());
            st.setDate(7, fullApplicationClient.getProductParameters().getRepaymentDate());
            st.setString(8, fullApplicationClient.getProductParameters().getDownPaymentSource());
            st.setInt(9, fullApplicationClient.getProductParameters().getDelayPeriod());
            st.setInt(10, fullApplicationClient.getProductParameters().getRefSum());
            st.execute();
            st = c.prepareStatement("INSERT INTO \"Loan\"\n" +
                    "(\"Type\", \"Status\", \"Annuity\", \"InitialAmount\", \"Outstanding\", \"PaidInterest\", \"PledgeValue\", \"DateFunded\", \"DateRealClose\")\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, fullApplicationClient.getLoan().getType());
            st.setString(2, fullApplicationClient.getLoan().getStatus());
            st.setInt(3, fullApplicationClient.getLoan().getAnnuity());
            st.setInt(4, fullApplicationClient.getLoan().getInitialAmount());
            st.setInt(5, fullApplicationClient.getLoan().getOutstanding());
            st.setInt(6, fullApplicationClient.getLoan().getPaidInterest());
            st.setInt(7, fullApplicationClient.getLoan().getPledgeValue());
            st.setDate(8, fullApplicationClient.getLoan().getDateFunded());
            st.setDate(9, fullApplicationClient.getLoan().getDateRealClose());
            st.execute();
            st = c.prepareStatement("insert into \"Participant\" DEFAULT VALUES;");
            st.execute();
            st = c.prepareStatement("insert into \"Finances\" DEFAULT VALUES;");
            st.execute();
            st = c.prepareStatement("INSERT INTO \"Income\"\n" +
                    "(\"Type\", \"Main\", \"Confirmation\", \"Periodicity\", \"PaymentManner\", \"Currency\", \"Value\", \"Average\")\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, fullApplicationClient.getIncome().getType());
            st.setString(2, fullApplicationClient.getIncome().getMain());
            st.setString(3, fullApplicationClient.getIncome().getConfirmation());
            st.setString(4, fullApplicationClient.getIncome().getPeriodicity());
            st.setString(5, fullApplicationClient.getIncome().getPaymentManner());
            st.setString(6, fullApplicationClient.getIncome().getCurrency());
            st.setString(7, fullApplicationClient.getIncome().getValue());
            st.setString(8, fullApplicationClient.getIncome().getAverage());
            st.execute();
            st = c.prepareStatement("INSERT INTO \"Credit\"\n" +
                    "(\"Index\", \"Type\", \"PrimaryKey\", \"ContractRef\", \"Currency\", \"IssueDate\", \"Annuity\", \"Product\", \"Comment\")\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, fullApplicationClient.getCredit().getIndex());
            st.setString(2, fullApplicationClient.getCredit().getType());
            st.setString(3, fullApplicationClient.getCredit().getPrimaryKey());
            st.setString(4, fullApplicationClient.getCredit().getContractRef());
            st.setString(5, fullApplicationClient.getCredit().getCurrency());
            st.setDate(6, fullApplicationClient.getCredit().getIssueDate());
            st.setString(7, fullApplicationClient.getCredit().getAnnuity());
            st.setString(8, fullApplicationClient.getCredit().getProduct());
            st.setString(9, fullApplicationClient.getCredit().getComment());
            st.execute();
            st = c.prepareStatement("INSERT INTO \"Employees\"\n" +
                    "(\"NAME\", \"SURNAME\", \"RANG\")\n" +
                    "VALUES(?, ?, ?);");
            st.setString(1, fullApplicationClient.getEmployess().getNAME());
            st.setString(2, fullApplicationClient.getEmployess().getSURNAME());
            st.setString(3, fullApplicationClient.getEmployess().getRANG());
            st.execute();
            st = c.prepareStatement("INSERT INTO \"Client\"\n" +
                    "(\"PARENTID\", \"BirthDate\", \"BirthPlace\", \"Age\", \"Gender\", \"Citizenship\", \"Education\", \"Surname\", \"Name\"," +
                    "\"Patronymic\", \"DocumentType\", \"Passportnum\", \"Issuedate\"," +
                    "\"IssuePlace\", \"IssueAuthority\", \"Departmentcode\", \"SNILS\")\n" +
                    "VALUES((select max(\"ID\") from \"Participant\"), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            st.setDate(1, fullApplicationClient.getClient().getBirthDate());
            st.setString(2, fullApplicationClient.getClient().getBirthPlace());
            st.setInt(3, fullApplicationClient.getClient().getAge());
            st.setString(4, fullApplicationClient.getClient().getGender());
            st.setString(5, fullApplicationClient.getClient().getCitizenship());
            st.setString(6, fullApplicationClient.getClient().getEducation());
            st.setString(7, fullApplicationClient.getClient().getSurname());
            st.setString(8, fullApplicationClient.getClient().getName());
            st.setString(9, fullApplicationClient.getClient().getPatronymic());
            st.setString(10, fullApplicationClient.getClient().getDocumentType());
            st.setString(11, fullApplicationClient.getClient().getPassportnum());
            st.setDate(12, fullApplicationClient.getClient().getIssuedate());
            st.setString(13, fullApplicationClient.getClient().getIssuePlace());
            st.setString(14, fullApplicationClient.getClient().getIssueAuthority());
            st.setString(15, fullApplicationClient.getClient().getDepartmentcode());
            st.setString(16, fullApplicationClient.getClient().getSNILS());
            st.execute();
            st = c.prepareStatement("insert into \"HistoryApplicationList\" DEFAULT VALUES;");
            st.execute();
            st = c.prepareStatement("INSERT INTO \"ApplicationList\"\n" +
                    "(\"PrimaryKey\", \"StageID\", \"ProductCategory\", \"ProductID\", \"ProductName\"," +
                    "\"MarketingSegment\", \"ParticipationType\", \"Limit\", \"Payment\"," +
                    "\"DateCreation\", \"DateApproved\", \"Status\", \"OpenDate\", \"FinishDate\")\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, fullApplicationClient.getApplicationList().getPrimaryKey());
            st.setString(2, fullApplicationClient.getApplicationList().getStageID());
            st.setString(3, fullApplicationClient.getApplicationList().getProductCategory());
            st.setString(4, fullApplicationClient.getApplicationList().getProductID());
            st.setString(5, fullApplicationClient.getApplicationList().getProductName());
            st.setString(6, fullApplicationClient.getApplicationList().getMarketingSegment());
            st.setString(7, fullApplicationClient.getApplicationList().getParticipationType());
            st.setInt(8, fullApplicationClient.getApplicationList().getLimit());
            st.setInt(9, fullApplicationClient.getApplicationList().getPayment());
            st.setDate(10, fullApplicationClient.getApplicationList().getDateCreation());
            st.setDate(11, fullApplicationClient.getApplicationList().getDateApproved());
            st.setString(12, fullApplicationClient.getApplicationList().getStatus());
            st.setDate(13, fullApplicationClient.getApplicationList().getOpenDate());
            st.setDate(14, fullApplicationClient.getApplicationList().getFinishDate());
            st.execute();
            st = c.prepareStatement("INSERT INTO \"ApplicationAggr\"\n" +
                    "(\"Type\", \"Number\", \"TotalLimit\", \"TotalPayment\", \"LimitProductCategory\", \"LimitProductName\", \"LastDateCreated\", \"LastDateFunded\")\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, fullApplicationClient.getApplicationAggr().getType());
            st.setInt(2, fullApplicationClient.getApplicationAggr().getNumber());
            st.setInt(3, fullApplicationClient.getApplicationAggr().getTotalLimit());
            st.setInt(4, fullApplicationClient.getApplicationAggr().getTotalPayment());
            st.setInt(5, fullApplicationClient.getApplicationAggr().getLimitProductCategory());
            st.setInt(6, fullApplicationClient.getApplicationAggr().getLimitProductName());
            st.setDate(7, fullApplicationClient.getApplicationAggr().getLastDateCreated());
            st.setDate(8, fullApplicationClient.getApplicationAggr().getLastDateFunded());
            st.execute();
            st = c.prepareStatement("INSERT INTO \"Declined\"\n" +
                    "(\"LastDate\")\n" +
                    "VALUES(?);");
            st.setDate(1, fullApplicationClient.getDeclined().getLastDate());
            st.execute();
            st = c.prepareStatement("INSERT INTO public.\"ProductDeclined\"\n" +
                    "(\"Type\", \"Number\")\n" +
                    "VALUES(?, ?);");
            st.setString(1, fullApplicationClient.getProductDeclined().getType());
            st.setInt(2, fullApplicationClient.getProductDeclined().getNumber());
            st.execute();
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
    }


    public void getFullApplicationLegal(int ID) {
        fullApplicationLegals.clear();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, psgr_lg, psgr_pw);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT \"Application\".\"ApplicationNum\", \"Application\".\"Stage\", \"Application\".\"Source\", \"Application\".\"Region\",\n" +
                    "\"Application\".\"Branch\", \"Application\".\"DateCreation\", \"Application\".\"Priority\",\n" +
                    "\"ApplicationAggr\".\"Type\" as \"TypeApAg\", \"ApplicationAggr\".\"Number\" as \"NumberApAg\", \n" +
                    "\"ApplicationAggr\".\"TotalLimit\", \"ApplicationAggr\".\"TotalPayment\", \"ApplicationAggr\".\"LimitProductCategory\",\n" +
                    "\"ApplicationAggr\".\"LimitProductName\", \"ApplicationAggr\".\"LastDateCreated\", \"ApplicationAggr\".\"LastDateFunded\",\n" +
                    "\"ApplicationList\".\"PrimaryKey\" as \"PrimaryApList\", \"ApplicationList\".\"StageID\", \"ApplicationList\".\"ProductCategory\",\n" +
                    "\"ApplicationList\".\"ProductID\", \"ApplicationList\".\"ProductName\",\n" +
                    "\"ApplicationList\".\"MarketingSegment\", \"ApplicationList\".\"ParticipationType\", \"ApplicationList\".\"Limit\",\n" +
                    "\"ApplicationList\".\"Payment\", \"ApplicationList\".\"DateCreation\", \"ApplicationList\".\"DateApproved\",\n" +
                    "\"ApplicationList\".\"Status\", \"ApplicationList\".\"OpenDate\", \"ApplicationList\".\"FinishDate\",\n" +
                    "\"LegalEntity\".\"CompanyName\",\n" +
                    "\"LegalEntity\".\"INN\", \"LegalEntity\".\"OGRN\", \"LegalEntity\".\"DateFoundation\",\n" +
                    "\"LegalEntity\".\"CompanyAge\", \"LegalEntity\".\"BusinessDuration\",\n" +
                    "\"LegalEntity\".\"BusinessFocus\", \"LegalEntity\".\"Sector\",\n" +
                    "\"LegalEntity\".\"EmployeesNumber\",\n" +
                    "\"Credit\".\"Index\", \"Credit\".\"Type\" as \"TypeCredit\", \"Credit\".\"PrimaryKey\" as \"PrimaryKeyCredit\",\n" +
                    "\"Credit\".\"ContractRef\", \"Credit\".\"Currency\", \"Credit\".\"IssueDate\" as \"IssueDateCredit\",\n" +
                    "\"Credit\".\"Annuity\", \"Credit\".\"Product\", \"Credit\".\"Comment\",\n" +
                    "\"Declined\".\"LastDate\",\n" +
                    "\"Employees\".\"NAME\" as \"NameEmployees\", \"Employees\".\"SURNAME\" as \"SurnameEmployees\", \"Employees\".\"RANG\",\n" +
                    "\"Income\".\"Type\" as \"TypeIncome\", \"Income\".\"Main\",\n" +
                    "\"Income\".\"Confirmation\", \"Income\".\"Periodicity\", \"Income\".\"PaymentManner\",\n" +
                    "\"Income\".\"Currency\", \"Income\".\"Value\", \"Income\".\"Average\",\n" +
                    "\"Loan\".\"Type\" as \"TypeLoan\", \"Loan\".\"Status\",\n" +
                    "\"Loan\".\"Annuity\", \"Loan\".\"InitialAmount\", \"Loan\".\"Outstanding\",\n" +
                    "\"Loan\".\"PaidInterest\", \"Loan\".\"PledgeValue\",\n" +
                    "\"Loan\".\"DateFunded\", \"Loan\".\"DateRealClose\",\n" +
                    "\"ProductDeclined\".\"Type\" as \"TypeProductDeclined\", \"ProductDeclined\".\"Number\" as \"NumberProductDeclined\",\n" +
                    "\"ProductParameters\".\"ProductCategory\", \"ProductParameters\".\"ProductName\",\n" +
                    "\"ProductParameters\".\"Purpose\", \"ProductParameters\".\"DisbursementDate\",\n" +
                    "\"ProductParameters\".\"RepaymentScheme\", \"ProductParameters\".\"FirstPaymentDate\",\n" +
                    "\"ProductParameters\".\"RepaymentDate\", \"ProductParameters\".\"DownPaymentSource\",\n" +
                    "\"ProductParameters\".\"DelayPeriod\", \"ProductParameters\".\"RefSum\"\n" +
                    "FROM \"Application\"\n" +
                    "inner join \"Participant\" on \"Participant\".\"PARENTID\"=\"Application\".\"ID\"\n" +
                    "inner join \"Terms\" ON \"Terms\".\"PARENTID\"=\"Application\".\"ID\"\n" +
                    "inner join \"ProductParameters\" ON \"ProductParameters\".\"PARENTID\"=\"Terms\".\"ID\"\n" +
                    "inner join \"Loan\" ON \"Loan\".\"PARENTID\"=\"ProductParameters\".\"ID\"\n" +
                    "inner join \"Finances\" ON \"Finances\".\"PARENTID\"=\"Participant\".\"ID\"\n" +
                    "inner join \"Income\" ON \"Income\".\"PARENTID\"=\"Finances\".\"ID\"\n" +
                    "inner join \"Credit\" ON \"Credit\".\"PARENTID\"=\"Finances\".\"ID\"\n" +
                    "inner join \"Employees\" ON \"Employees\".\"PARENTID\"=\"Participant\".\"ID\"\n" +
                    "inner join \"LegalEntity\" ON \"LegalEntity\".\"PARENTID\"=\"Participant\".\"ID\"\n" +
                    "inner join \"HistoryApplicationList\" ON \"HistoryApplicationList\".\"PARENTID\"=\"Participant\".\"ID\"\n" +
                    "inner join \"ApplicationList\" ON \"ApplicationList\".\"PARENTID\"=\"HistoryApplicationList\".\"ID\"\n" +
                    "inner join \"ApplicationAggr\" ON \"ApplicationAggr\".\"PARENTID\"=\"HistoryApplicationList\".\"ID\"\n" +
                    "inner join \"Declined\" ON \"Declined\".\"PARENTID\"=\"HistoryApplicationList\".\"ID\"\n" +
                    "inner join \"ProductDeclined\" on \"ProductDeclined\".\"PARENTID\"=\"Declined\".\"ID\" where \"LegalEntity\".\"ID\"=?;");
            preparedStatement.setInt(1, ID);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                ApplicationAggr applicationAggr = new ApplicationAggr(result.getString("TypeApAg"),
                        result.getInt("NumberApAg"),
                        result.getInt("TotalLimit"),
                        result.getInt("TotalPayment"),
                        result.getInt("LimitProductCategory"),
                        result.getInt("LimitProductName"),
                        result.getDate("LastDateCreated"),
                        result.getDate("LastDateFunded")
                );
                ApplicationList applicationList = new ApplicationList(result.getString("PrimaryApList"),
                        result.getString("StageID"),
                        result.getString("ProductCategory"),
                        result.getString("ProductID"),
                        result.getString("ProductName"),
                        result.getString("MarketingSegment"),
                        result.getString("ParticipationType"),
                        result.getInt("Limit"),
                        result.getInt("Payment"),
                        result.getDate("DateCreation"),
                        result.getDate("DateApproved"),
                        result.getString("Status"),
                        result.getDate("OpenDate"),
                        result.getDate("FinishDate")
                );
                Application application = new Application(result.getString("ApplicationNum"),
                        result.getString("Stage"),
                        result.getString("Source"),
                        result.getString("Region"),
                        result.getString("Branch"),
                        result.getDate("DateCreation"),
                        result.getString("Priority")
                );
                LegalEntity legalEntity = new LegalEntity(result.getString("CompanyName"),
                        result.getString("INN"),
                        result.getString("OGRN"),
                        result.getDate("DateFoundation"),
                        result.getString("CompanyAge"),
                        result.getString("BusinessDuration"),
                        result.getString("BusinessFocus"),
                        result.getString("Sector"),
                        result.getString("EmployeesNumber")
                );
                Credit credit = new Credit(result.getString("Index"),
                        result.getString("TypeCredit"),
                        result.getString("PrimaryKeyCredit"),
                        result.getString("ContractRef"),
                        result.getString("Currency"),
                        result.getDate("IssueDateCredit"),
                        result.getString("Annuity"),
                        result.getString("Product"),
                        result.getString("DateCreation")
                );
                Declined declined = new Declined(result.getDate("LastDate")
                );
                Employess employess = new Employess(result.getString("NameEmployees"),
                        result.getString("SurnameEmployees"),
                        result.getString("RANG")
                );
                Income income = new Income(result.getString("TypeIncome"),
                        result.getString("Main"),
                        result.getString("Confirmation"),
                        result.getString("Periodicity"),
                        result.getString("PaymentManner"),
                        result.getString("Currency"),
                        result.getString("Value"),
                        result.getString("Average")
                );
                Loan loan = new Loan(result.getString("TypeLoan"),
                        result.getString("Status"),
                        result.getInt("Annuity"),
                        result.getInt("InitialAmount"),
                        result.getInt("Outstanding"),
                        result.getInt("PaidInterest"),
                        result.getInt("PledgeValue"),
                        result.getDate("DateFunded"),
                        result.getDate("DateRealClose")
                );
                ProductDeclined productDeclined = new ProductDeclined(result.getString("TypeProductDeclined"),
                        result.getInt("NumberProductDeclined")
                );
                ProductParameters productParameters = new ProductParameters(result.getString("ProductCategory"),
                        result.getString("ProductName"),
                        result.getString("Purpose"),
                        result.getDate("DisbursementDate"),
                        result.getString("RepaymentScheme"),
                        result.getDate("FirstPaymentDate"),
                        result.getDate("RepaymentDate"),
                        result.getString("DownPaymentSource"),
                        result.getInt("DelayPeriod"),
                        result.getInt("RefSum")
                );
                fullApplicationLegals.add(new FullApplicationLegal(application, applicationAggr, applicationList, legalEntity, credit, declined, employess, income,
                        loan, productDeclined, productParameters));
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
