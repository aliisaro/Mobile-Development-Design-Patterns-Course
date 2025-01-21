import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import app.CourseRecord
import app.Human
import app.Major
import app.Student

internal class StudyRegisterTest {
    private val students = ArrayList<Student>()
    fun createStudents() {
        var student: Student
        student = Student("Enzio Benzino", 21)
        student.addCourse(CourseRecord("Kotlin basics", 2023,5, 5.0))
        student.addCourse(CourseRecord("Java basics", 2023, 5, 1.0))
        student.addCourse(CourseRecord("Scala basics", 2023, 3, 2.0))
        students.add(student)
        student = Student("Abebe Bikila", 23)
        student.addCourse(CourseRecord("Kotlin basics", 2023, 5, 2.0))
        students.add(student)
        student = Student("Günther Radulic", 20)
        student.addCourse(CourseRecord("Kotlin basics", 2023, 5, 4.0))
        student.addCourse(CourseRecord("Kotlin advanced", 2023, 5, 5.0))
        students.add(student)
    }
    @Test
    fun testHuman() {
        val a = Human("Abebe Bikila",21)
        assert(a.name == "Abebe Bikila")
        assert(a.age == 21)
        a.getOlder()
        assert(a.age == 22)
    }
    @Test
    fun testAverage() {
        createStudents()
        assertEquals(2.7692, students[0].weightedAverage(), 0.001)
    }
    @Test
    fun testMinMax() {
        createStudents()
        val (minGrade, maxGrade) = students[0].minMaxGrades()
        assertEquals(1.0, minGrade, 0.001)
        assertEquals(5.0, maxGrade, 0.001)
    }
    @Test
    fun testMajor() {
        createStudents()
        val major = Major("True Programming")
        for (student in students) {
            major.addStudent(student)
        }
        val (majorMin, majorMax, majorAverage) = major.stats()
        assertEquals(2.0, majorMin, 0.001)
        assertEquals(4.5, majorMax, 0.001)
        assertEquals(3.0897, majorAverage, 0.001)

        val (majorMin2, majorMax2, majorAverage2) = major.stats("Kotlin basics")
        assertEquals(2.0, majorMin2, 0.001)
        assertEquals(5.0, majorMax2, 0.001)
        assertEquals(3.6666, majorAverage2, 0.001)
    }
}
