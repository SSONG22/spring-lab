package songi.lab.spring.toby.chap7;

public interface SqlService {
    String getSql(String key) throws SqlRetrievalFailureException;
}
