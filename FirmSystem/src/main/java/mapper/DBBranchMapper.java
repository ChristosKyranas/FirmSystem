package mapper;

import model.Branch;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBBranchMapper {

    public static Branch mapBranchToRs(ResultSet rs) throws SQLException {
        return new Branch(
//            resultSet.getString
        );
    }

}
