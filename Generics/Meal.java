/*
4. Personalized Meal Plan Generator
Concepts: Generic Methods, Type Parameters, Bounded Type Parameters
Problem Statement:
Design a Personalized Meal Plan Generator where users can choose different meal categories like Vegetarian, Vegan, Keto, or High-Protein. The system should ensure only valid meal plans are generated.
Hints:
Define an interface MealPlan with subtypes (VegetarianMeal, VeganMeal, etc.).
Implement a generic class Meal<T extends MealPlan> to handle different meal plans.
Use a generic method to validate and generate a personalized meal plan dynamically.
*/

import java.util.ArrayList;
import java.util.List;
interface MealPlan {

    String kindOfMeal();
    String getMealName();
}

class VegetarianMeal implements MealPlan {
    String mealName;
    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }
    @Override
    public String kindOfMeal() {
        return ("Vegetarian Meal");
    }  
    @Override
    public String getMealName() {
        return this.mealName;
    }
}
class VeganMeal implements MealPlan {
    String mealName;
    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }
    @Override
    public String kindOfMeal() {
        return ("Vegan Meal");
    }
    @Override
    public String getMealName() {
        return this.mealName;
    }
    
}
class NonVeg implements MealPlan {
    String mealName;
    public NonVeg(String mealName) {
        this.mealName = mealName;
    }
    @Override
    public String kindOfMeal() {
        return ("Non-Veg Meal");
    }
    public String getMealName() {
        return this.mealName;
    }
}
public class Meal<T extends MealPlan>{
    ArrayList<T> mealList = new ArrayList<>();
    public void addMeal(T meal) {
        mealList.add(meal);
    }
    public List<T> getMealList() {
        return mealList;
    }
    public static <T extends MealPlan> void  displayMeals(List<? extends MealPlan> mealList){
        for(MealPlan meal : mealList){
            System.out.println( meal.getMealName()+" " + meal.kindOfMeal());
        }
    
    }
    public static void main(String[] args) {
        Meal<MealPlan> planner = new Meal<>();
        planner.addMeal(new NonVeg("Chicken 65"));
        planner.addMeal(new VeganMeal("Veg Burger"));
        planner.addMeal(new VegetarianMeal("Veg Pizza"));
        displayMeals(planner.getMealList());

      
    }
}