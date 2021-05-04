package java6308.lesson01;

public class Person6308 extends Market6308 {

    private String personname;

    public Person6308() {
    }

    public Person6308(String personname) {
        this.personname = personname;
    }

    public String getPersonname() {
        return personname;
    }

    /**
     *
     * @param personname
     */
    public void setPersonname(String personname) {
        this.personname = personname;
    }


    //买一件
    public Product6308 shopping(Market6308 marketname, String yy) {
        return marketname.sell(yy);
    }
    //买多件
    public String shopping(Market6308 marketname, Product6308[] qq) {
        return marketname.sell(qq);
    }

    @Override
    public String toString() {
        return   personname;
    }
}
