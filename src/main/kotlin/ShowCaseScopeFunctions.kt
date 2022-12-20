/**
 * Zeigt die ScopeFunctions
 * https://kotlinlang.org/docs/scope-functions.html
 */
class ShowCaseScopeFunctions {

    //region 0. Texts
    companion object Texts{
        private const val SHOW_CASE_NAME = "\n###################\n# Scope Functions #\n###################\n"

        private const val INSTANTIATION_MODIFICATION_WITH_OUT_LET = "\n# Instanziierung und Modifizierung ohne .let #\n"
        private const val INSTANTIATION_MODIFICATION_WITH_LET = "\n# Instanziierung und Modifizierung mit .let #\n"

        private const val AFTER_INSTANTIATION = "Nach Instanziierung:\t"
        private const val AFTER_MODIFICATION = "Nach Aenderung:\t\t\t"

        private const val CHANGE_CITY_AND_AGE = "\n>>Stadt und Alter aendern\n"

        private const val LAMBDA_RESULT = "Lambdaergebnis:\t\t\t"

        private const val TEST_NAME_ALICE = "Alice"
        private const val STARTING_AGE = 20
        private const val FIRST_CITY = "Amsterdam"
        private const val SECOND_CITY = "London"
    }

    //endregion

    //region 1. Start ShowCase
    fun startShowCase() {
        this.printShowCaseName();
        this.showMeHowScopeFunctionsWork();
    }
    //endregion

    //region Print ShowCase Name
    private fun printShowCaseName() {
        println(SHOW_CASE_NAME)
    }
    //endregion

    //region 2. HowTo:
    private fun showMeHowScopeFunctionsWork() {
        showMeHowLetWorks()
    }
    //endregion


    //region 3 .let{...}
    private fun showMeHowLetWorks() {
        this.showMeTheObjectGenerationAndModificationWithOutLet()
        this.showMeTheObjectGenerationAndModificationWithLet()
    }

    private fun showMeTheObjectGenerationAndModificationWithOutLet() {

        println(INSTANTIATION_MODIFICATION_WITH_OUT_LET)

        //1. Objekt generieren
        var alice = Person(TEST_NAME_ALICE, STARTING_AGE, FIRST_CITY)

        //2. Objekt direkt nach Instanziierung ausgeben
        println("$AFTER_INSTANTIATION$alice")

        println(CHANGE_CITY_AND_AGE)

        //3. Objekt Attribute veraendern
        alice.moveTo(SECOND_CITY)
        alice.incrementAge()

        //4. Objekt nach Aenderung ausgeben
        println("$AFTER_MODIFICATION$alice")

    }

    private fun showMeTheObjectGenerationAndModificationWithLet() {
        println(INSTANTIATION_MODIFICATION_WITH_LET)

        //1. Objekt generieren
        val lambdaResultFromLetChainedToPersonConstructor = Person(TEST_NAME_ALICE, STARTING_AGE, FIRST_CITY).let {

            //2. Objekt direkt nach Instanziierung ausgeben
            println("$AFTER_INSTANTIATION$it")

            println(CHANGE_CITY_AND_AGE)

            //3. Objekt Attribute veraendern
            it.moveTo(SECOND_CITY)
            it.incrementAge()

            //4. Objekt nach Aenderung ausgeben
            println("$AFTER_MODIFICATION$it")
        }

        println("$LAMBDA_RESULT$lambdaResultFromLetChainedToPersonConstructor")
    }
    //endregion
}