package songi.lab.spring.toby.chap7;

import javax.annotation.PostConstruct;

public class BaseSqlService implements SqlService {
    protected SqlReader sqlReader;
    protected SqlRegistry sqlRegistry;
    // BaseSqlService는 상속을 통해 확장해서 사용하기에 적합하다. 서브클래스에서 접근할 수 있도록 protected로 선언한다.


    public void setSqlReader(SqlReader sqlReader) {
        this.sqlReader = sqlReader;
    }

    public void setSqlRegistry(SqlRegistry sqlRegistry) {
        this.sqlRegistry = sqlRegistry;
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException {
        try {
            return this.sqlRegistry.findSql(key);
        } catch (SqlNotFoundExcpeion e) {
            throw new SqlRetrievalFailureException(e.getMessage());
        }
    }

    @PostConstruct
    public void loadSql(){
        this.sqlReader.read(this.sqlRegistry);
    }
}
