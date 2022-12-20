package logic

import model.Person
import testData.TestPersons

/**
 * Zeigt die ScopeFunctions
 * https://kotlinlang.org/docs/scope-functions.html
 */
class ShowCaseScopeFunctions {

    //region 0. Texts
    companion object Texts {
        private const val SHOW_CASE_NAME = "\n###################\n# Scope Functions #\n###################\n"

        private const val INSTANTIATION_MODIFICATION_WITH_OUT_SCOPE_FUNCTION =
            "\n# Instanziierung und Modifizierung ohne ScopeFunction #\n"

        private const val SCOPE_FUNCTION_LET = "\n+~* .let {...} *~+\n"
        private const val INSTANTIATION_MODIFICATION_WITH_LET = "\n# Instanziierung und Modifizierung mit .let #\n"

        private const val SCOPE_FUNCTION_RUN = "\n+~* .run {...} *~+\n"
        private const val INSTANTIATION_MODIFICATION_WITH_RUN = "\n# Instanziierung und Modifizierung mit .run #\n"

        private const val SCOPE_FUNCTION_ALSO = "\n+~* .also {...} *~+\n"
        private const val SCOPE_FUNCTION_APPLY = "\n+~* .apply {...} *~+\n"

        private const val AFTER_INSTANTIATION = "Nach Instanziierung:\t"
        private const val AFTER_MODIFICATION = "Nach Aenderung:\t\t\t"

        private const val CHANGE_CITY_AND_AGE = "\n>> Stadt und Alter aendern\n"

        private const val LAMBDA_RESULT_OF_LET_AND_RUN = "Lambdaergebnis:\t\t\t"
        private const val OBJECT_RESULT_OF_ALSO_AND_APPLY = "Objektergebnis:\t\t\t\t"

        private const val NEW_EMPTY_LIST_OF_PERSONS = "Neue leere Personenliste:\t"

        private const val ADD_PERSONS_TO_LIST = "\n>> Fuege Personenen zur Liste hinzu"

        private const val ADDED_FIRST_PERSON_TO_LIST = "\n>> Erste model.Person zur Liste hinzugefuegt"
        private const val ADDE_ALL_PERSONS_TO_THE_LIST = ">> Alle Personen hinzugefuegt"
        private const val FILLED_LIST = "\nBefuellte Liste:\t\t\t"
        private const val SIZE_OF_LIST = "\nGroesse der Liste:\t\t\t"


    }

    //endregion

    //region 1. Start ShowCase
    fun startShowCase() {
        this.printShowCaseName();
        this.showMeHowScopeFunctionsWork();
    }
    //endregion

    //region 2. Print ShowCase Name
    private fun printShowCaseName() {
        println(SHOW_CASE_NAME)
    }
    //endregion

    //region 3. HowTo:
    private fun showMeHowScopeFunctionsWork() {
        this.showMeHowLetWorks()
        this.showMeHowRunWorks()

        this.showMeHowAlsoWorks()
        this.showMeHowApplyWorks()
    }


    //endregion

    //region 4 .let {...}
    private fun showMeHowLetWorks() {
        println(SCOPE_FUNCTION_LET)

        this.showMeTheObjectGenerationAndModificationWithOutScopeFunctions()

        this.showMeTheObjectGenerationAndModificationWithLet()
    }

    private fun showMeTheObjectGenerationAndModificationWithLet() {
        println(INSTANTIATION_MODIFICATION_WITH_LET)

        //1. Objekt generieren
        val lambdaResultFromLetChainedToPersonConstructor =
            TestPersons.getAlice().let {

                //2. Objekt direkt nach Instanziierung ausgeben
                println("$AFTER_INSTANTIATION$it")

                println(CHANGE_CITY_AND_AGE)

                //3. Objekt Attribute veraendern
                it.moveTo(TestPersons.COLLEGE_CITY_OF_ALICE)
                it.incrementAge()

                //4. Objekt nach Aenderung ausgeben
                println("$AFTER_MODIFICATION$it")
            }

        println("$LAMBDA_RESULT_OF_LET_AND_RUN$lambdaResultFromLetChainedToPersonConstructor")
    }
    //endregion

    //region 5. .run {...}
    private fun showMeHowRunWorks() {
        println(SCOPE_FUNCTION_RUN)

        this.showMeTheObjectGenerationAndModificationWithOutScopeFunctions()
        this.showMeTheObjectGenerationAndModificationWithRun()
    }

    private fun showMeTheObjectGenerationAndModificationWithRun() {
        println(INSTANTIATION_MODIFICATION_WITH_RUN)

        //1. Objekt generieren
        val lambdaResultFromLetChainedToPersonConstructor =
            TestPersons.getAlice().run {

                //2. Objekt direkt nach Instanziierung ausgeben
                println("$AFTER_INSTANTIATION$this")

                println(CHANGE_CITY_AND_AGE)

                //3. Objekt Attribute veraendern
                this.moveTo(TestPersons.COLLEGE_CITY_OF_ALICE)
                this.incrementAge()

                //4. Objekt nach Aenderung ausgeben
                println("$AFTER_MODIFICATION$this")
            }

        println("$LAMBDA_RESULT_OF_LET_AND_RUN$lambdaResultFromLetChainedToPersonConstructor")
    }
    //endregion

    //region 6. .also {...}
    private fun showMeHowAlsoWorks() {
        println(SCOPE_FUNCTION_ALSO)

        val persons = mutableListOf<Person>()

        println(AFTER_INSTANTIATION)
        println("$NEW_EMPTY_LIST_OF_PERSONS$persons")

        val personsFromAlso = persons.also { println(ADD_PERSONS_TO_LIST) }
            .also { it.add(TestPersons.getAlice()) }
            .also { println(ADDED_FIRST_PERSON_TO_LIST) }
            .also { it.add(TestPersons.getShrek()) }
            .also { println("$ADDE_ALL_PERSONS_TO_THE_LIST") }
            .also { println("$SIZE_OF_LIST${it.size}") }

        println("$FILLED_LIST$persons")
        println("$OBJECT_RESULT_OF_ALSO_AND_APPLY$personsFromAlso")
    }
    //endregion

    //region 7. .apply {...}
    private fun showMeHowApplyWorks() {
        println(SCOPE_FUNCTION_APPLY)

        val persons = mutableListOf<Person>()

        println(AFTER_INSTANTIATION)
        println("$NEW_EMPTY_LIST_OF_PERSONS$persons")


        val personsFromApply = persons.apply {
            println(ADD_PERSONS_TO_LIST)

            add(TestPersons.getAlice())

            println(ADDED_FIRST_PERSON_TO_LIST)

            add(TestPersons.getShrek())

            println("$ADDE_ALL_PERSONS_TO_THE_LIST")

            println("$SIZE_OF_LIST$size")
        }

        println("$FILLED_LIST$persons")
        println("$OBJECT_RESULT_OF_ALSO_AND_APPLY$personsFromApply")
    }




    //endregion

    //region 8. ObjectGenerationAndModificationWithOutScopeFunctions
    private fun showMeTheObjectGenerationAndModificationWithOutScopeFunctions() {

        println(INSTANTIATION_MODIFICATION_WITH_OUT_SCOPE_FUNCTION)

        //1. Objekt generieren
        var alice = TestPersons.getAlice()

        //2. Objekt direkt nach Instanziierung ausgeben
        println("$AFTER_INSTANTIATION$alice")

        println(CHANGE_CITY_AND_AGE)

        //3. Objekt Attribute veraendern
        alice.moveTo(TestPersons.COLLEGE_CITY_OF_ALICE)
        alice.incrementAge()

        //4. Objekt nach Aenderung ausgeben
        println("$AFTER_MODIFICATION$alice")

    }


    //endregion
}