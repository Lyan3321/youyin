package youyin_MB;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import junit.framework.TestCase;

public class JDBCTest extends TestCase {

	public void testC3P0() throws PropertyVetoException, SQLException{
		ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
		
		System.out.println(cpds.getConnection());
	}
}
