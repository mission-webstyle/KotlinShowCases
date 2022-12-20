package model

class Person (
    private var name:  String,
    private var age:Int,
    private var city:String
) {
    constructor(name: String) :this(name,0,"")

    fun incrementAge(){
        ++this.age;
    }

    fun moveTo(city: String){
        this.city = city
    }

    override fun toString(): String {
        return "model.Person(name='$name', age=$age, city='$city')"
    }


}