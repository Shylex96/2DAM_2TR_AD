package es.studium.exist;

import javax.xml.xquery.*;
import javax.xml.namespace.QName;
import net.xqj.exist.ExistXQDataSource;

public class ExistBD
{
	public static void main(String[] args) throws XQException
	{
		XQDataSource xqs = new ExistXQDataSource();
		xqs.setProperty("serverName", "localhost");
		xqs.setProperty("port", "8080");

		XQConnection conn = xqs.getConnection();

		XQPreparedExpression xqpe =
				conn.prepareExpression("declare variable $x as xs:string external; $x");

		xqpe.bindString(new QName("x"), "Hello World!", null);

		XQResultSequence rs = xqpe.executeQuery();

		while(rs.next())
			System.out.println(rs.getItemAsString(null));

		conn.close();
	}
}
