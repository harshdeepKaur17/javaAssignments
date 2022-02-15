package ques2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Collector;
import static java.util.stream.Collectors.toList;

import ques2.Dish.Type;
public class Main {

	
	public  DishSelected getDishSelectedField(Dish d){
		return new DishSelected(d.getName(), d.getCalories());
	}
	public static void main(String[] args) {

		List<Dish> allDishes = getAllDishes();
		
		//1. return the names of dishes that are low in calories (<400) sorted by number of calories
		List<String> names = allDishes.stream()
				.parallel()
				.filter(dish->dish.getCalories()<400)
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(dish->dish.getName())
				.collect(Collectors.toList());
		//names.forEach(name->System.out.println(name));
		
		
		//2. Getting all veg dishes
			List<Dish> vegDishes = allDishes.stream()
					.filter(dish->dish.isVegetarian())
					.collect(Collectors.toList());
			//vegDishes.forEach(dish->System.out.println(dish));
			
		
		//3. Get list of All Dishes only containing name and calValue			
			List<DishSelected> allDisheHavingNameAndCalValue = allDishes
														.stream()
														.map(d-> new DishSelected(d.getName(),d.getCalories()))
														.collect(toList());
		//	allDisheHavingNameAndCalValue.forEach(name->System.out.println(name));
			
			
		//4. Create a List by selecting the first three dishes that have more than 300 calories
			List<Dish> firstThreeMoreThan300 = allDishes
									.stream()
									.filter(dish->dish.getCalories()>300)
									.limit(3)
									.collect(Collectors.toList());
			//firstThreeMoreThan300.forEach(dish->System.out.println(dish));
	
			

		//5. find out whether the menu has a vegetarian option: anyMatch
			boolean hasVeg = allDishes.stream()
							.anyMatch(dish->dish.isVegetarian());
			//System.out.println(hasVeg);
			
			
		//6. find out whether the menu ishealthy :allMatch
		// (ie. all dishes are below 1000 calories):
			boolean isHealthy = allDishes
								.stream()
								.allMatch(dish->dish.getCalories()<1000);
			//System.out.println(isHealthy);
		
			
		//7. noneMatch: opposite of allMatch
			boolean hasHealthy = allDishes
								.stream()
								.noneMatch(dish->dish.getCalories()>=1000);
			//System.out.println(hasHealthy);
			
		//8. Find if any food item is veg? findAny
			Optional<Dish> findAnyVegFood = allDishes
									.stream()
									.filter(dish->dish.isVegetarian())
									.findAny();
		//	String result = findAnyVegFood.map(Dish::getName).orElse("Not Found");
			
		
		// Primitive stream specializations

		// IntStream,DoubleStream, and LongStream==> avoid boxing cost

		//9 Get all the cal values of all food items
			int totalCalories = allDishes
								.stream()
								.map(dish->dish.getCalories())
								.reduce(0, (x,y)->x+y);
			//System.out.println(totalCalories);
			
			
		//10 using primitive stream
			int totalCalories2 = allDishes.stream()
								.mapToInt(dish->dish.getCalories())
								.sum();
			//System.out.println(totalCalories2);
			
			
		//11. Find max calories values for all dishes, Optional
			Integer maxCalories = allDishes
								.stream()
								.max(Comparator.comparing(Dish::getCalories))
								.map(dish->dish.getCalories())
								.orElse(-1);
			//System.out.println(maxCalories);
			
		/*
		 * What type of queries Collect helps:Collectors.groupingBy(..)
		 * ------------------------------------- 
		 * 1. Dishes grouped by type 
		 * 2. Dishes grouped by calorie level 
		 * 3. Dishes grouped by type and then caloric level 
		 * 4. Count dishes in each groups 
		 * 5. Most caloric dishes by type 
		 * 6. Sum calories by type
		 */
		
		//1. Dishes grouped by type
			Map<Type, List<Dish>> collect = allDishes.stream()
					.collect(Collectors.groupingBy( d-> d.getType()));
			collect.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				entry.getValue().forEach(dish->System.out.println(dish));
			});
			
		//2. Dishes grouped by calorie level
		/*
		 * if (dish.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		 * 
		 */
			Map<Integer, List<Dish>> groupByCalorie = allDishes.stream()
								.collect(Collectors.groupingBy(Dish::getCalories));
			groupByCalorie.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				entry.getValue().forEach(dish->System.out.println(dish));
			});
			
		//3. Dishes grouped by type and then caloric level 
			Map<Type, Map<Integer, List<Dish>>> groupByTypeThenCalorie = allDishes.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.groupingBy(Dish::getCalories)));
			
			groupByTypeThenCalorie.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				entry.getValue().forEach((calorie,dish)->{
					System.out.println(calorie);
					System.out.println(dish);
				});
			});
		
		//4. Count dishes in each groups 
			Map<Type, Long> countDishes = allDishes.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));
		
			countDishes.entrySet().forEach(entry->{
				System.out.println(entry.getKey()+" : "+entry.getValue());
			});
			
		//5. Most calorie dishes by Type
			Map<Type, Optional<Dish>> mostCalorieDishByType = allDishes.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
	
			mostCalorieDishByType.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				System.out.println(entry.getValue().orElseThrow(RuntimeException::new));
			});
			
		//6. Sum calories by type
			Map<Type, Integer> sum = allDishes.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.summingInt(Dish::getCalories)));
			sum.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
			});
	}

	

	private static List<Dish> getAllDishes() {
		List<Dish> disheds = Arrays.asList(new Dish("pork", false, 800,
				Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish(
						"french fries", true, 530, Dish.Type.OTHER), new Dish(
						"rice", true, 350, Dish.Type.OTHER), new Dish(
						"season fruit", true, 120, Dish.Type.OTHER), new Dish(
						"pizza", true, 550, Dish.Type.OTHER), new Dish(
						"prawns", false, 300, Dish.Type.FISH), new Dish(
						"salmon", false, 300, Dish.Type.FISH));
		return disheds;
	}
}
