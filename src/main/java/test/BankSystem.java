package test;

import test.Models.Application;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import test.Models.ApplicationAggr;
import test.Models.ApplicationList;
import test.Requests.Example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BankSystem {
    private List<Object> applications = new ArrayList<Object>();
    private List<Example> examples = new ArrayList<Example>();
    public Application application_test;

    public List<Object> getApplications() {
        return applications;
    }

    public BankSystem() {
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
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

    public void getApplication(int ID) {
        applications.clear();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, psgr_lg, psgr_pw);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT \"Application\".\"ApplicationNum\", \"Application\".\"Stage\", \"Application\".\"Source\", \"Application\".\"Region\",\n" +
                    "\"Application\".\"Branch\", \"Application\".\"DateCreation\", \"Application\".\"Priority\" FROM \"Application\"\n" +
                    "inner join \"Participant\" on \"Participant\".\"PARENTID\"=\"Application\".\"ID\" \n" +
                    "inner join \"Client\" on \"Client\".\"PARENTID\"=\"Participant\".\"ID\" where \"Client\".\"ID\"=?;");
            preparedStatement.setInt(1, ID);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Application application = new Application(result.getString("ApplicationNum"),
                        result.getString("Stage"),
                        result.getString("Source"),
                        result.getString("Region"),
                        result.getString("Branch"),
                        result.getDate("DateCreation"),
                        result.getString("Priority")
                );
                applications.add(application);
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void getFullApplicationClient(int ID) {
        examples.clear();
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
                    "\"Client\".\"BirthDate\", \"Client\".\"BirthPlace\",\n" +
                    "\"Client\".\"Age\", \"Client\".\"Gender\", \"Client\".\"Citizenship\", \"Client\".\"Education\",\n" +
                    "\"Client\".\"Surname\" as \"SurnameClient\", \"Client\".\"Name\" as \"NameClient\", \"Client\".\"Patronymic\", \"Client\".\"DocumentType\",\n" +
                    "\"Client\".\"Passportnum\", \"Client\".\"Issuedate\", \"Client\".\"IssuePlace\",\n" +
                    "\"Client\".\"IssueAuthority\", \"Client\".\"Departmentcode\", \"Client\".\"SNILS\",\n" +
                    "\"Credit\".\"Index\", \"Credit\".\"Type\" as \"TypeCredit\", \"Credit\".\"PrimaryKey\",\n" +
                    "\"Credit\".\"ContractRef\", \"Credit\".\"Currency\", \"Credit\".\"IssueDate\",\n" +
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
                    "inner join \"ProductDeclined\" on \"ProductDeclined\".\"PARENTID\"=\"Declined\".\"ID\" where \"Client\".\"ID\"=?;");
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
                ApplicationList applicationList = new ApplicationList(result.getString("PrimaryKey"),
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
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
//                Application application = new Application(result.getString("ApplicationNum"),
//                        result.getString("Stage"),
//                        result.getString("Source"),
//                        result.getString("Region"),
//                        result.getString("Branch"),
//                        result.getDate("DateCreation"),
//                        result.getString("Priority")
//                );
                examples.add(new Example(applicationAggr, applicationList, application));
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void app_test() {
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
                    "\"Client\".\"BirthDate\", \"Client\".\"BirthPlace\",\n" +
                    "\"Client\".\"Age\", \"Client\".\"Gender\", \"Client\".\"Citizenship\", \"Client\".\"Education\",\n" +
                    "\"Client\".\"Surname\" as \"SurnameClient\", \"Client\".\"Name\" as \"NameClient\", \"Client\".\"Patronymic\", \"Client\".\"DocumentType\",\n" +
                    "\"Client\".\"Passportnum\", \"Client\".\"Issuedate\", \"Client\".\"IssuePlace\",\n" +
                    "\"Client\".\"IssueAuthority\", \"Client\".\"Departmentcode\", \"Client\".\"SNILS\",\n" +
                    "\"Credit\".\"Index\", \"Credit\".\"Type\" as \"TypeCredit\", \"Credit\".\"PrimaryKey\",\n" +
                    "\"Credit\".\"ContractRef\", \"Credit\".\"Currency\", \"Credit\".\"IssueDate\",\n" +
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
                    "inner join \"ProductDeclined\" on \"ProductDeclined\".\"PARENTID\"=\"Declined\".\"ID\" where \"Client\".\"ID\"=?;");
            preparedStatement.setInt(1, 1130);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                application_test = new Application(result.getString("ApplicationNum"),
                        result.getString("Stage"),
                        result.getString("Source"),
                        result.getString("Region"),
                        result.getString("Branch"),
                        result.getDate("DateCreation"),
                        result.getString("Priority")
                );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
