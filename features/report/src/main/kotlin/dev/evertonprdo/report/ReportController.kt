package dev.evertonprdo.report

import dev.evertonprdo.domain.GetReport

class ReportController(
    private val getReport: GetReport
) {

    fun printReport() {
        val report = getReport()
        println("TOTAL TODOS: $report")
    }
}