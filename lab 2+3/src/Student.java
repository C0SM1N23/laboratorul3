
public class Student extends Persoana {
    int grupa;
    public Student(String nume, String prenume, int grupa)
    {
        super(nume, prenume);
        this.grupa = grupa;
    }
    @Override
    public String toString() {
        return "Student{" + "nume=" + nume + ", prenume=" + prenume + ", grupa=" +
                grupa + '}';
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public int getGrupa() {
        return grupa;
    }
    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }
}