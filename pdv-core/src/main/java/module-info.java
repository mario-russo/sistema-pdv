module pdv.core {
    exports br.com.mario.model;
    exports br.com.mario.dataBese;
    requires transitive  java.sql;

    opens br.com.mario.model to org.mockito;
}
