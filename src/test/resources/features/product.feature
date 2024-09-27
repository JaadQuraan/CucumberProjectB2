Feature: product data table practice

  @product
  Scenario: verify each product price
    # practice List<Map<String, Sting>>
    Given User is on the HomePage
    Then User should be able to see expected prices in following products
      | Category | Product           | expectedPrice |
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |

    #List has 8 elements, each element is a Map, each Map has a key and value
  #Said map in step definitions so first is taken as a key
  @product

  Scenario: verify each product price listOfList
    Given User is on the HomePage
    Then User should be able to see expected prices in following products with listOflist
      | Phones   | Samsung galaxy s6 | 360 |
      | Phones   | Nokia lumia 1520  | 820 |
      | Phones   | Nexus 6           | 650 |
      | Laptops  | Sony vaio i5      | 790 |
      | Laptops  | Sony vaio i7      | 790 |
      | Laptops  | MacBook air       | 700 |
      | Monitors | Apple monitor 24  | 400 |
      | Monitors | ASUS Full HD      | 230 |

  # practice Map<String, List<String>>
  @mapList
  Scenario: verify students names on discord
    Then User should be able to see the following names in their groups
      | Group 1 | Parvana | Yuliia    | Feyruz |
      | Group 2 | Maya    | Ievgeniia | Nadir  |
      | Group 3 | Gavin   | Caglar    | Loop   |

# Maps key string, value is list of String