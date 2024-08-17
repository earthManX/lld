package LLD;

import java.util.*;

/*
 * You have a movie renting company consisting of n shops. You want to implement a renting system that
 *  supports searching for, booking, and returning movies. 
 * The system should also support generating a report of the currently rented movies.

Each movie is given as a 2D integer array entries where entries[i] = [shopi, moviei, pricei] indicates that 
there is a copy of movie moviei at shop shopi with a rental price of pricei. Each shop carries at most one copy of a
 movie moviei.

The system should support the following functions:

Search: Finds the cheapest 5 shops that have an unrented copy of a given movie. The shops should be 
sorted by price in ascending order, and in case of a tie, the one with the smaller shopi should appear first. 
If there are less than 5 matching shops, then all of them should be returned. If no shop has an unrented copy, 
then an empty list should be returned.
Rent: Rents an unrented copy of a given movie from a given shop.
Drop: Drops off a previously rented copy of a given movie at a given shop.
Report: Returns the cheapest 5 rented movies (possibly of the same movie ID) as a 2D list res where
 res[j] = [shopj, moviej] describes that the jth cheapest rented movie moviej was rented from the shop shopj.
The movies in res should be sorted by price in ascending order, and in case of a tie, the one with the smaller 
shopj should appear first, and if there is still tie, the one with the smaller moviej should appear first.
If there are fewer than 5 rented movies, then all of them should be returned. If no movies are currently being rented, 
then an empty list should be returned.
Implement the MovieRentingSystem class:

MovieRentingSystem(int n, int[][] entries) Initializes the MovieRentingSystem object with n shops and the movies in entries.
List<Integer> search(int movie) Returns a list of shops that have an unrented copy of the given movie as described above.
void rent(int shop, int movie) Rents the given movie from the given shop.
void drop(int shop, int movie) Drops off a previously rented movie at the given shop.
List<List<Integer>> report() Returns a list of cheapest rented movies as described above.
Note: The test cases will be generated such that rent will only be called if the shop has an unrented copy of the movie, and drop will only be called if the shop had previously rented out the movie.
 */

 /* Shops -> Movies -> Price
  * [shopi, moviei, pricei]
  movie -> status (boolean)

  Search patterns 
  : Find by movie, sort by price and availability
  : Find by shop and movie
  : Sort by price

  Rather than PQ, TreeSet is the way to go here. Check commented solution at the end.
  */ 
public class MovieRentingSystem {

    class Movie{
        int price;
        int shop;
        int id;
        boolean isRented;

        Movie(int price, int shop, int id, boolean status){
            this.price = price;
            this.shop = shop;
            this.id = id;
            this.isRented = status;
        }
    }

    Map< Integer, List<Movie>> movieMap;
    PriorityQueue<Movie> cheapestRented;
    PriorityQueue<Movie> cheapestUnrented;
    List<List<Integer>> report = new ArrayList<>();

    public MovieRentingSystem(int n, int[][] entries) {
        // Key : movie, Value : [shop, price, status]
        movieMap = new HashMap<>();
        cheapestRented = new PriorityQueue<>(
        (m1,m2) -> {
            if( m1.price != m2.price ){
                return m1.price-m2.price;
            }else if(m1.shop != m2.shop){
                return m1.shop - m2.shop;
            }
            return m1.id - m2.id;
        });

        cheapestUnrented = new PriorityQueue<>(
        (m1,m2) -> {
            if( m1.price != m2.price ){
                return m1.price-m2.price;
            }else if(m1.shop != m2.shop){
                return m1.shop - m2.shop;
            }
            return m1.id - m2.id;
        });

        for( int[] entry : entries){
            List<Movie> movies = movieMap.getOrDefault(entry[1], new ArrayList<>());
            movies.add(new Movie( entry[2], entry[0], entry[1],  false));
            movieMap.put(entry[1], movies);
        }
    }
    
    public List<Integer> search(int movie) {
        cheapestUnrented.clear();
        List<Integer> cheapUnrented = new ArrayList<>();
        if( movieMap.get(movie) != null){
            movieMap.get(movie).forEach( m -> {
                if( !m.isRented ){
                    cheapestUnrented.add(m);
                }
            });
        }
        if(!cheapestUnrented.isEmpty()){
            int i = 5;
            while( i > 0 && !cheapestUnrented.isEmpty()){
                Movie m = cheapestUnrented.poll();
                cheapUnrented.add(m.shop);
                i--;
            }
        }
        return cheapUnrented;
    }
    
    public void rent(int shop, int movie) {
        Optional<Movie> toBeRentedMovie = movieMap.get(movie).stream().filter(m -> m.shop == shop).findFirst();
        if(toBeRentedMovie.isPresent()){
            toBeRentedMovie.get().isRented = true;
            cheapestRented.add(toBeRentedMovie.get());
        }
    }
    
    public void drop(int shop, int movie) {
        Optional<Movie> toBeReturnedMovie = movieMap.get(movie).stream().filter(m -> m.shop == shop).findFirst();
        if(toBeReturnedMovie.isPresent()){
            toBeReturnedMovie.get().isRented = false;
            cheapestRented.remove(toBeReturnedMovie.get());
        }
    }
    
    public List<List<Integer>> report() {
        report.clear();
        int i = 5;
        while(i > 0 && !cheapestRented.isEmpty()){
            Movie m = cheapestRented.poll();
            report.add(new ArrayList<>(Arrays.asList(m.shop, m.id)));
            i--;
        }
        return report;
    }

    public static void main( String[] args){
        MovieRentingSystem mrs = new MovieRentingSystem(3,   new int[][] { new int[] {0,1,5}, new int[] {1,1,4}, new int[] {2,1,7}, new int[] {3,1,4}, new int[] {4,1,7}, new int[] {6,1,5}});
        mrs.search(1);
    }
}

/*
 * class MovieRentingSystem {

	private class Entry {
		int shop, movie, price;
		Entry(int shop, int movie, int price){
			this.shop = shop;
			this.movie = movie;
			this.price = price;
		}
	}

	private TreeSet<Entry> rented;
	private HashMap<Integer, Set<Entry>> unrented;
	private HashMap<Pair<Integer,Integer>, Integer> price;

	Comparator<Entry> comparator = (e1,e2) -> {
		if (e1.price != e2.price) return Integer.compare(e1.price, e2.price); 
		if (e1.shop != e2.shop) return Integer.compare(e1.shop, e2.shop);
		return Integer.compare(e1.movie, e2.movie);
	};

	public MovieRentingSystem(int n, int[][] entries) {
		rented = new TreeSet<>(comparator);
		unrented = new HashMap<>(); 
		price = new HashMap<>();

		for(int[] entry: entries){
			int shop = entry[0], movie = entry[1], p = entry[2];
			unrented.computeIfAbsent(movie, e -> new TreeSet<>(comparator)).add(new Entry(shop, movie, p));
			price.put(new Pair(shop,movie), p);
		}
	}

	public List<Integer> search(int movie) {
		return unrented.getOrDefault(movie, Collections.emptySet()).stream().limit(5).map(e -> e.shop).collect(Collectors.toList());
	}

	public void rent(int shop, int movie) {
		int p = price.get(new Pair(shop,movie)); 
		rented.add(new Entry(shop, movie, p));
		unrented.get(movie).remove(new Entry(shop,movie,p)); 
	}

	public void drop(int shop, int movie) {
		int p = price.get(new Pair(shop,movie)); 
		rented.remove(new Entry(shop, movie, p)); 
		unrented.get(movie).add(new Entry(shop,movie,p)); 
	}

	public List<List<Integer>> report() {
		return rented.stream().limit(5).map(e -> List.of(e.shop, e.movie)).collect(Collectors.toList());
	}
}
*/
