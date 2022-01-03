package songi.lab.spring.toby.chap7;

import org.springframework.core.io.Resource;

import javax.xml.bind.Unmarshaller;

public class OxmSqlService implements SqlService {

    private Unmarshaller unmarshaller;
    private SqlRegistry sqlRegistry;
    private Resource sqlmap;

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void setSqlRegistry(SqlRegistry sqlRegistry) {
        this.sqlRegistry = sqlRegistry;
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException {
        return null;
    }

    public void setSqlmap(Resource sqlmap) {
        this.sqlmap = sqlmap;
    }
}
