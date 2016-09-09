package cpe200;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CourseTest {

    private Course c;

    @Test
    public void defaultConstructor() throws Exception {
        c = new Course();
        assertEquals("TBA", c.getCourse_name());
        assertEquals("000000", c.getCourse_id());
        assertEquals("TBA", c.getLecturer());
        assertEquals(30, c.getMax_students() );
        assertEquals(0, c.getNo_students());
    }

    @Test
    public void parameterizedConstructor() throws Exception {
        c = new Course("Web Programming", "269103", "Kenneth Cosh", 40);
        assertEquals("Web Programming", c.getCourse_name());
        assertEquals("269103", c.getCourse_id());
        assertEquals("Kenneth Cosh", c.getLecturer());
        assertEquals(40, c.getMax_students() );
        assertEquals(0, c.getNo_students());
    }

    @Before
    public void setUp() throws Exception {
        c = new Course("CPE200-OOP", "261344", "Pruet Boonma", 60);
    }

    @Test
    public void validAttributes() throws Exception {
        c.setCourse_id("261200");
        c.setLecturer(c.getLecturer() + " and Dome Potikanond");
        c.setMax_students(60);

        assertEquals("261200", c.getCourse_id());
        assertEquals("Pruet Boonma and Dome Potikanond", c.getLecturer());
        assertEquals(60, c.getMax_students());
    }

    @Test
    public void invalidAttributes() throws Exception {
        c.setCourse_name("");
        c.setCourse_id("CPE200");
        c.setLecturer("");
        c.setMax_students(-10);

        assertEquals("CPE200-OOP", c.getCourse_name());
        assertEquals("261344", c.getCourse_id());
        assertEquals("Pruet Boonma", c.getLecturer());
        assertEquals(60, c.getMax_students() );

        c.setCourse_id("2612003");
        assertEquals("261344", c.getCourse_id());
        c.setNo_students(80);
        assertEquals(0, c.getNo_students());
        c.setNo_students(-3);
        assertEquals(0, c.getNo_students());

    }

    @Test
    public void checkToStringNoStudent() throws Exception {
        c.setLecturer(c.getLecturer() + " and Dome Potikanond");
        c.setCourse_id("261200");
        assertEquals("CPE200-OOP (261200), Teacher: Pruet Boonma and Dome Potikanond"
                + ", has NO student, [maximum: 60]", c.toString());
    }

    @Test
    public void checkToStringOneStudent() throws Exception {
        c.setNo_students(1);
        c.setCourse_id("261200");
        c.setLecturer(c.getLecturer() + " and Dome Potikanond");
        assertEquals("CPE200-OOP (261200), Teacher: Pruet Boonma and Dome Potikanond"
                + ", has ONE student, [maximum: 60]", c.toString());
    }

    @Test
    public void checkToStringManyStudent() throws Exception {
        c.setNo_students(45);
        c.setCourse_id("261200");
        c.setLecturer(c.getLecturer() + " and Dome Potikanond");
        assertEquals("CPE200-OOP (261200), Teacher: Pruet Boonma and Dome Potikanond"
                + ", has 45 students, [maximum: 60]", c.toString());
    }
}