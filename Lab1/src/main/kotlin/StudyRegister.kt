package app

open class Human(val name: String, var age: Int) {
    fun getOlder() {
        age += 1
    }
}
class CourseRecord(val name: String, var yearCompleted: Int, var credits: Int, var grade: Double) {}

class Student(name: String, age: Int) : Human(name, age) {
    var courses: MutableList<CourseRecord> = mutableListOf()

    fun addCourse(course: CourseRecord) {
        courses += course
    }

    fun weightedAverage(): Double {
        val totalCredits = courses.sumOf { it.credits }
        val totalWeighted = courses.sumOf { it.credits * it.grade }
        val average = totalWeighted / totalCredits
        return average
    }

    fun weightedAverage(year: Int): Double {
        val filteredCourses = courses.filter { it.yearCompleted == year }
        val totalCredits = filteredCourses.sumOf { it.credits }
        val totalWeighted = filteredCourses.sumOf { it.credits * it.grade }
        val average = totalWeighted / totalCredits
        return average
    }

    fun minMaxGrades(): Pair<Double, Double> {
        val minGrade = courses.minOf { it.grade }
        val maxGrade = courses.maxOf { it.grade }
        return Pair(minGrade, maxGrade)
    }
}

class Major(val name: String) {
    private val students: MutableList<Student> = mutableListOf()

    fun addStudent(student: Student) {
        students += student
    }

    fun stats(): Triple<Double, Double, Double> {
        val averages = students.map { it.weightedAverage() }
        val min = averages.minOrNull() ?: 0.0
        val max = averages.maxOrNull() ?: 0.0
        val avg = if (averages.isNotEmpty()) averages.average() else 0.0
        return Triple(min, max, avg)
    }

    fun stats(courseName: String): Triple<Double, Double, Double> {
        val courseAverages = students.mapNotNull { student ->
            val filteredCourses = student.courses.filter { it.name == courseName }
            if (filteredCourses.isNotEmpty()) {
                val totalCredits = filteredCourses.sumOf { it.credits }
                val totalWeighted = filteredCourses.sumOf { it.credits * it.grade }
                totalWeighted / totalCredits
            } else null
        }
        val min = courseAverages.minOrNull() ?: 0.0
        val max = courseAverages.maxOrNull() ?: 0.0
        val avg = if (courseAverages.isNotEmpty()) courseAverages.average() else 0.0
        return Triple(min, max, avg)
    }
}