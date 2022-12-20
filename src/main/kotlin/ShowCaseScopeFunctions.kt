
/**
 * Zeigt die ScopeFunctions
 * https://kotlinlang.org/docs/scope-functions.html
 */
class ShowCaseScopeFunctions {

    companion object{
        private const val SHOW_CASE_NAME = "\n###################\n# Scope Functions #\n###################"
    }
    fun startShowCase(){
        this.printShowCaseName();
        this.showMeHowScopeFunctionsWork();
    }
    private fun printShowCaseName() {
        println(SHOW_CASE_NAME)
    }
    private fun showMeHowScopeFunctionsWork() {
        showMeHowLetWorks()
    }
    private fun showMeHowLetWorks() {
        var alice = Person("Alice", 20, "Amsterdam")
        println(alice)
    }
}