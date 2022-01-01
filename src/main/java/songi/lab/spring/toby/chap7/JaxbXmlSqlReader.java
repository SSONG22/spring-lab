package songi.lab.spring.toby.chap7;

public class JaxbXmlSqlReader implements SqlReader {
    private static final String DEFAULT_SQLMAP_FILE = "sqlmap.xml";

    private String sqlmapFile = DEFAULT_SQLMAP_FILE;

    // sqlmapFile프로퍼티를 지정하면 지정된 파일이 사용되고 아니면 디폴트로 넣은 파일이 ㅏ용된다.
    public void setSqlmapFile(String sqlmapFile) {
        this.sqlmapFile = sqlmapFile;
    }

    @Override
    public void read(SqlRegistry sqlRegistry) {
//        String contextPath = Sqlmap.class.getPackage().getName();
//
//        try {
//            JAXBContext context = JAXBContext.newInstance(contextPath);
//            Unmarshaller unmarshaller = context.createUnmashaller();
//            InputStream is = UserDao.class.getResourceAsStream("sqlmap.xml");
//            Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(is);
//
//            // 읽어온 SQL을 맵으로 저장한다.
//            for (SqlType sql : sqlmap.getSql()) {
//                sqlMap.put(sql.getKey(), sql.getValue());
//            }
//        } catch (JAXBException e) {
//            throw new RuntimeException(e); // 복구 불가능한 예외.
//        }
    }
}
