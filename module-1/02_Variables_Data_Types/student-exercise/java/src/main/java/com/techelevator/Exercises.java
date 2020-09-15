package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int startingRaccoons = 3;
		int raccoonsThatLeft = 2;
		int raccoonsInWoods = startingRaccoons - raccoonsThatLeft;
		System.out.println("There are " + raccoonsInWoods + "raccoons left in the woods");

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowers = 5;
		int bees = 3;
		int beesMinusFlowers = flowers - bees;
		System.out.println("Bees - Flowers = " + beesMinusFlowers);

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int initialPigeons = 1;
		int pigeonsJoined = 1;
		int totalPigeons = initialPigeons + pigeonsJoined;
		System.out.println("There are " + totalPigeons + " total pigeons");

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int initialOwls = 3;
		int owlsJoined = 1;
		int totalOwls = initialOwls + owlsJoined;
		System.out.println("There are " + totalOwls + " total owls");

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int initialBeavers = 2;
		int beaversThatLeft = 1;
		int totalBeavers = initialBeavers - beaversThatLeft;
		System.out.println("There are " + totalBeavers + " total beavers working on their home");

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansInitial = 2;
		int toucansThatJoined = 1;
		int toucansTotal = toucansInitial - toucansThatJoined;
		System.out.println("There are " + toucansTotal + " total toucans");

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrelsTotal = 4;
		int nutsTotal = 2;
		int squirrelNutDifference = squirrelsTotal - nutsTotal;
		System.out.println("There are " + squirrelNutDifference + " more squirrels than nuts");

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarterVal = 1 * 0.25;
		double dimeVal = 1 * 0.10;
		double nickelVal = 2 * 0.05;
		double quarterTotal = 1 * quarterVal;
		double dimeTotal = 1 * dimeVal;
		double nickelTotal = 2 * nickelVal;
		double totalMoney = quarterTotal + dimeTotal + nickelTotal;
		System.out.println("Mrs. Hilt has $" + totalMoney);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int muffinsBrier = 18;
		int muffinsMacAdams = 20;
		int muffinsFlannery = 17;
		int muffinsTotal = muffinsBrier + muffinsMacAdams + muffinsFlannery;
		System.out.println("Mrs. Hilt's first grade classes baked " + muffinsTotal + " muffins");

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoyoCost = 0.24;
		double whistleCost = 0.14;
		double totalCostToys = yoyoCost + whistleCost;
		System.out.println("The cost of the toys came to $" + totalCostToys);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int riceKrispies = 5;
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;
		System.out.println("Mrs. Hilt used " + totalMarshmallows + " total marshmallows");

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int snowHiltInches = 29;
		int snowBrecknockInches = 17;
		int snowDiffHiltBreck = snowHiltInches - snowBrecknockInches;
		System.out.println("The diffence between snow is " + snowDiffHiltBreck + " inches");

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		double startingMoney = 10.00;
		double toyTruckCost = 3.00;
		double pencilCaseCost = 2.00;
		double moneySpent = toyTruckCost + pencilCaseCost;
		double moneyLeftOver = startingMoney - moneySpent;
		System.out.println("Mrs. Hily has $" + moneyLeftOver + " left");
		

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int initialMarbles = 16;
		int lostMarbles = 7;
		int finalMarbles = initialMarbles - lostMarbles;
		System.out.println("Josh has " + finalMarbles + " marbles now");

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int shellsTotal = 25;
		int shellsMeganHas = 19;
		int shellsNeedsNow = shellsTotal - shellsMeganHas;
		System.out.println("Megan needs " + shellsNeedsNow + " seashells to get to 25");

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int balloonsTotal = 17;
		int redBalloons = 8;
		int greenBallons = balloonsTotal - redBalloons;
		System.out.println("Brad has " + greenBallons + " green balloons");

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int booksOnShelfInitial = 38;
		int martaBooks = 10;
		int booksOnShelfFinal = booksOnShelfInitial + martaBooks;
		System.out.println("There are " + booksOnShelfFinal + " books on the shelf");

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int beeLegs = 6;
		int beesTotal = 8;
		int legsOnTotalBees = beeLegs * beesTotal;
		System.out.println("The total legs on all the bees is " + legsOnTotalBees);

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double iceCreamCost = 0.99;
		int iceCreamBought = 2;
		double totalIceCreamCost = iceCreamCost * iceCreamBought;
		System.out.println("The total cost of ice cream cones cost $" + totalIceCreamCost);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int rocksReqd = 125;
		int hiltRocks = 64;
		int hiltRocksStillNeeds = rocksReqd - hiltRocks;
		System.out.println("Mrs. Hilt still needs " + hiltRocksStillNeeds + " rocks to complete the border");

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int initMarbles = 38;
		int marblesLost = 15;
		int finalMarblesNow = initMarbles - marblesLost;
		System.out.println("Mrs. Hilt has " + finalMarblesNow + " marbles left");

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int milesConcert = 78;
		int milesToGas = 38;
		int milesToGo = milesConcert - milesToGas;
		System.out.println("Mrs. Hilt and sister needs to drive " + milesToGo + " miles");

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int timeShovelingMorning = 90;
		int timeShovelingAfternoon = 45;
		int timeShovelingTotal = timeShovelingMorning + timeShovelingAfternoon;
		System.out.println("Mrs. Hilt spent " + timeShovelingTotal + " minutes shoveling");

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int totalHotdogs = 6;
		double hotdogCost = 0.50;
		double totalHotdogCost = totalHotdogs * hotdogCost;
		System.out.println("Mrs. Hilt spent $" + totalHotdogCost + " on hotdogs");

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		double moneyOnHand = 0.50;
		double pencilCost = 0.07;
		double pencilsWeCanBuy = Math.round((moneyOnHand / pencilCost));
		System.out.println("Mrs. Hilt is poor and can only afford " + pencilsWeCanBuy + " pencils");

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterfly = 33;
		int orangeButterfly = 20;
		int redButterfly = totalButterfly - orangeButterfly;
		System.out.println("There were " + redButterfly + " red butterflies");

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double clerkMoneyRec = 1.00;
		double candyCost = 0.54;
		double kateChange = clerkMoneyRec - candyCost;
		System.out.println("Kate got $" + kateChange + " cash back");

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int treesBkyd = 13;
		int treesPlanted = 12;
		int totalTrees = treesBkyd + treesPlanted;
		System.out.println("Mark will have " + totalTrees + " trees in his backyard");

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int daysToHours = 24;
		int daysTilGranny = 2;
		int hoursTilGranny = daysToHours * daysTilGranny;
		System.out.println("Joy will see her granny in " + hoursTilGranny + " hours");

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kimsCousins = 4;
		int gumPerPerson = 5;
		int gumNeeded = kimsCousins * gumPerPerson;
		System.out.println("Kim needs " + gumNeeded + " pieces of gum");

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double danInitCash = 3.00;
		double candyBarCost = 1.00;
		double moneyDanHasFinal = danInitCash - candyBarCost;
		System.out.println("Dan has $" + moneyDanHasFinal + " left over");

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsLake = 5;
		int peoplePerBoat = 3;
		int totalPeople = boatsLake * peoplePerBoat;
		System.out.println("There are a total of " + totalPeople + " people on boats");

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int legosInit = 380;
		int legosLost = 57;
		int legosFinal = legosInit - legosLost;
		System.out.println("Ellen has " + legosFinal + " legos left");

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int artInitMuffins = 35;
		int muffinsNeedToBake = 83;
		int muffinsArtNeedsToBake = muffinsNeedToBake - artInitMuffins;
		System.out.println("Arthur still needs to bake " + muffinsArtNeedsToBake + " muffins");

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int diffInCrayons = willyCrayons - lucyCrayons;
		System.out.println("Willy has " + diffInCrayons + " more crayons more than Lucy");

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int totalPages = 22;
		int totalStickers = stickersPerPage * totalPages;
		System.out.println("There are " + totalStickers + " total stickers");

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakes = 96;
		int totalChildren = 8;
		int cupcakesPerChild = totalCupcakes / totalChildren;
		System.out.println("Each person will get " + cupcakesPerChild + " cupcakes");

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int gingerCookies = 47;
		int totalJars = 6;
		int cookiesLeftInJar = gingerCookies % totalJars;
		System.out.println("There will be " + cookiesLeftInJar + " cookies left in jar");

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int totalCrois = 59;
		int totalNeighb = 8;
		int croisPerNeighb = totalCrois % totalNeighb;
		System.out.println("Marian will have " + croisPerNeighb + " croissants left over");

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int totalOatmeal = 276;
		int oatmealPerTray = 12;
		int traysNeeded = totalOatmeal / oatmealPerTray;
		System.out.println("Marian will need " + traysNeeded + " trays");

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalPretz = 480;
		int servSize = 12;
		int totalServs = totalPretz / servSize;
		System.out.println("Marian has " + totalServs + " pretzel servings");

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemCakes = 53;
		int homeCakes = 2;
		int cakesPerBox = 3;
		int lemBoxes = (lemCakes - homeCakes) / cakesPerBox;
		System.out.println("There were " + lemBoxes + " lemon cupcake boxes given away");

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carSticks = 74;
		int carPeople = 12;
		int carSticksLeft = carSticks % carPeople;
		System.out.println("There are " + carSticksLeft + " carrot sticks left");

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int susBears = 98;
		int bearsPerShelf = 7;
		int shelfFilled = susBears / bearsPerShelf;
		System.out.println("Susie can fill " + shelfFilled + " shelves");

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int albumLimit = 20;
		int totalPics = 480;
		int albumsReqd = totalPics / albumLimit;
		System.out.println("There are " + albumsReqd + " albums required");

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalCards = 94;
		int cardsPerBox = 8;
		int boxesFilled = totalCards / cardsPerBox;
		int cardsLeftOver = totalCards % cardsPerBox;
		System.out.println("There are " + boxesFilled + " boxes filled and " + cardsLeftOver + " cards left over");

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalBooks = 210;
		int shelvesTotal = 10;
		int booksPerShelf = totalBooks / shelvesTotal;
		System.out.println("There are " + booksPerShelf + " books per shelf");

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int croiBaked = 17;
		int guestsTotal = 7;
		int croiPerGuest = croiBaked / guestsTotal;
		System.out.println("Each guest gets " + croiPerGuest + " croissants");

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}
