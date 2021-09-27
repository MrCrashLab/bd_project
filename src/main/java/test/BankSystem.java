package test;

import test.Models.ApplicationForClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BankSystem {
    private final List<ApplicationForClient> applicationForClient;
    private ApplicationForClient application;

    public List<ApplicationForClient> getApplicationForClient() {
        return applicationForClient;
    }

    public BankSystem() {
        this.applicationForClient = new ArrayList<ApplicationForClient>();
    }

    public ApplicationForClient getApplication() {
        return application;
    }

    @Value( "${jdbc_url}" )
    @JsonIgnore
    private String jdbcUrl;

    @Value( "${psgr_lg}" )
    @JsonIgnore
    private String psgr_lg;

    @Value( "${psgr_pw}" )
    @JsonIgnore
    private String psgr_pw;

    public void getApplication(int ID)
    {
        applicationForClient.clear();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, psgr_lg, psgr_pw);
            PreparedStatement preparedStatement = connection.prepareStatement("select \"Application\".\"ApplicationNum\", \"Application\".\"Stage\", \"Application\".\"Source\", \"ProductParameters\".\"ProductCategory\", \"ProductParameters\".\"ProductName\", \"ProductParameters\".\"Purpose\", \"ProductParameters\".\"DisbursementDate\", \"ProductParameters\".\"RepaymentScheme\", \"ProductParameters\".\"FirstPaymentDate\", \"ProductParameters\".\"RepaymentDate\", \"ProductParameters\".\"DownPaymentSource\", \"ProductParameters\".\"DelayPeriod\", \"ProductParameters\".\"RefSum\", \"Loan\".\"Type\", \"Loan\".\"Status\", \"Loan\".\"Annuity\", \"Loan\".\"InitialAmount\", \"Loan\".\"Outstanding\", \"Loan\".\"PaidInterest\", \"Loan\".\"PledgeValue\", \"Loan\".\"DateFunded\", \"Loan\".\"DateRealClose\" from \"Application\" inner join \"Terms\" on \"Terms\".\"PARENTID\"=\"Application\".\"ID\" inner join \"ProductParameters\" on \"ProductParameters\".\"PARENTID\"=\"Terms\".\"ID\" inner join \"Loan\" on \"Loan\".\"PARENTID\"=\"ProductParameters\".\"ID\" inner join \"Participant\" on \"Participant\".\"PARENTID\"=\"Application\".\"ID\" inner join \"Client\" on \"Client\".\"PARENTID\"=\"Participant\".\"ID\" where \"Client\".\"ID\"=?;\n");
            preparedStatement.setInt(1, ID);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                ApplicationForClient test = new ApplicationForClient(result.getString("ApplicationNum"),
                        result.getString("Stage"),
                        result.getString("Source"),
                        result.getString("ProductCategory"),
                        result.getString("ProductName"),
                        result.getString("Purpose"),
                        result.getDate("DisbursementDate"),
                        result.getString("RepaymentScheme"),
                        result.getDate("FirstPaymentDate"),
                        result.getDate("RepaymentDate"),
                        result.getString("DownPaymentSource"),
                        result.getInt("DelayPeriod"),
                        result.getInt("RefSum"),
                        result.getString("Type"),
                        result.getString("Status"),
                        result.getInt("Annuity"),
                        result.getInt("InitialAmount"),
                        result.getInt("Outstanding"),
                        result.getInt("PaidInterest"),
                        result.getInt("PledgeValue"),
                        result.getDate("DateFunded"),
                        result.getDate("DateRealClose")
                );
                applicationForClient.add(test);
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
        application = applicationForClient.get(0);
    }

}
