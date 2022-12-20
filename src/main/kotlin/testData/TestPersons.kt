package testData

import model.Person

/**
 * Stellt Test[Person]s zru Verfuegung
 */
class TestPersons private constructor(){
    companion object{
        private const val SHREK = "Shrek"
        private const val AGE_OF_SHREK = 123
        private const val HOME_TOWN_OF_SHREK = "WeitWeitWeg - Am Schlammtuempel"

        private const val ALICE = "Alice"
        private const val AGE_OF_ALICE = 20
        private const val HOME_TOWN_OF_ALICE = "Amsterdam"
        const val COLLEGE_CITY_OF_ALICE = "London"

        fun getAlice() = Person(ALICE, AGE_OF_ALICE, HOME_TOWN_OF_ALICE)
        fun getShrek() = Person(SHREK, AGE_OF_SHREK, HOME_TOWN_OF_SHREK)
    }
}