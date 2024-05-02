package mapper;

import model.Firm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBFirmMapper {

    private static final String NAME = "name";
    private static final String FIRM_ID = "firm_id";
    private static final String ACTIVE = "active";

    public static Firm mapFirmToRs(ResultSet resultSet) throws SQLException {
        return new Firm(
            resultSet.getInt(FIRM_ID),
            resultSet.getString(NAME),
            resultSet.getInt(ACTIVE)
        );
    }

}
