import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerCursuri {
    private Curs[] cursuri;
    Profesor[] profesori;
    Student[] studenti;

    public ManagerCursuri() {
        cursuri = new Curs[0];
        profesori = new Profesor[0];
    }

    public void AddCurs(Curs curs) {
        int noualungime = cursuri.length + 1;
        Curs[] aux = new Curs[noualungime];
        System.arraycopy(cursuri, 0, aux, 0, cursuri.length);
        aux[cursuri.length] = curs;
        this.cursuri = aux;
    }


    public void UpdateCurs(String nume, String descriere) {
        for (int i = 0; i < cursuri.length; i++) {
            if (cursuri[i].getNume().equals(nume)) {
                cursuri[i].setDescriere(descriere);
                break;
            }
        }
    }
    public void DeleteCurs(Curs curs) {
        int index = -1;
        for (int i = 0; i < cursuri.length; i++) {
            if (cursuri[i].equals(curs)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < cursuri.length - 1; i++) {
                cursuri[i] = cursuri[i + 1];
            }
            Curs[] newCursuri = new Curs[cursuri.length - 1];
            System.arraycopy(cursuri, 0, newCursuri, 0, newCursuri.length);
            cursuri = newCursuri;
        }
    }
    public void AfiseazaProfesori() {
        if (profesori.length == 0) {
            System.out.println("Nu există profesori în listă.");
        } else {
            System.out.println("Lista profesorilor:");
            for (Profesor profesor : profesori) {
                System.out.println("Profesor: " + profesor.getNume() + " " + profesor.getPrenume() + ", ID: " + profesor.getId());
            }
        }
    }
    public void UpdateProfesor(Profesor profesorNou) {
        for (int i = 0; i < profesori.length; i++) {
            if (profesori[i].getId().equals(profesorNou.getId())) {
                profesori[i] = profesorNou;
                break;
            }
        }
    }

    public void AdaugaProfesor(Profesor profesor) {
        Profesor[] aux = new Profesor[profesori.length + 1];
        System.arraycopy(profesori, 0, aux, 0, profesori.length);
        aux[profesori.length] = profesor;
        profesori = aux;
    }

    public void StergeProfesor(String idProfesor) {
        int index = -1;
        for (int i = 0; i < profesori.length; i++) {
            if (profesori[i].getId().equals(idProfesor)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Profesor[] aux = new Profesor[profesori.length - 1];
            for (int i = 0, j = 0; i < profesori.length; i++) {
                if (i != index) {
                    aux[j++] = profesori[i];
                }
            }
            profesori = aux;
        }
    }

    public void AdaugaStudentLaCurs(String numeCurs, Student studentNou) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.AddStudent(studentNou);
                break;
            }
        }
    }
    public  void UpdateStudent(Student student)
    {


    }
    public void removeStudent(Student student) {
        int count = 0;

        for (Student s : studenti) {
            if (!(s.getNume().equals(student.getNume()) &&
                    s.getPrenume().equals(student.getPrenume()) &&
                    s.getGrupa() == student.getGrupa())) {
                count++;
            }
        }
        Student[] newStudenti = new Student[count];
        int index = 0;
        for (Student s : studenti) {
            if (!(s.getNume().equals(student.getNume()) &&
                    s.getPrenume().equals(student.getPrenume()) &&
                    s.getGrupa() == student.getGrupa())) {
                newStudenti[index++] = s;
            }
        }
        studenti = newStudenti;
    }


    public void ModificaProfesorLaCurs(String numeCurs, Profesor profesorNou) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.UpdateProfesor(profesorNou);
                break;
            }
        }
    }

    public void RaporteazaStudentiLaCurs(String numeCurs) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.raporteazaNoteCurs();
                break;
            }
        }
    }

    public void AfiseazaCursuriLaConsola() {
        for (Curs c : cursuri) {
            System.out.println(c);
        }
    }

    public void RaporteazaNoteleStudentilorLaCurs(String numeCurs) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.raporteazaNoteCurs();
                break;
            }
        }
    }

    public double RaporteazaMediaStudentilorLaCurs(String numeCurs) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                return curs.calculeazaMedia();
            }
        }
        return 0.0;
    }

    public double RaporteazaMediaNotelorDateDeProfesor(Profesor profesor) {
        double suma = 0.0;
        int numarNote = 0;

        for (Curs curs : cursuri) {
            if (curs.profesor.equals(profesor)) {
                double media = curs.calculeazaMedia();
                suma += media;
                numarNote++;
            }
        }

        return numarNote == 0 ? 0.0 : suma / numarNote;
    }
}
