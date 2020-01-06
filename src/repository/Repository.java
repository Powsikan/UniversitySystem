
package repository;

import java.sql.ResultSet;

public interface Repository {
    ResultSet userCheck(String query, String username, String password);

    void userPost(String query, String username, String password);

}
