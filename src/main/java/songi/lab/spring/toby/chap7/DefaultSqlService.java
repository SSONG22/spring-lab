package songi.lab.spring.toby.chap7;

public class DefaultSqlService extends BaseSqlService {
    public DefaultSqlService(){
        setSqlReader(new JaxbXmlSqlReader());
        setSqlRegistry(new HashMapSqlRegistry());
    }
}
