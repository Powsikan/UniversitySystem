
package repository;

import java.sql.ResultSet;

public interface Repository {
    ResultSet userCheck(String query, String username, String password);
    ResultSet getCourse(String query,String stu_no);

    void userPost(String query, String username, String password,String stu_No,String stu_Name);

}
