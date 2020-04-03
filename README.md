# neo4j

- This is a graph database.
- A Graph Database has the following
  - Nodes
    - A node can have **properties**
    - A node can have **Labels** too. That's why its called **Labeled Property Graph**
      - Label are nothing but **types**
    - A node can have **relationship** with other nodes
      - A relationship can also have **properties**


## Syntax for creating the Data

```
create(:label{prop1:"prop1value"}) -[:relationship]->(:label{prop1:"prop1value"})
```

### Example

#### One Directional Relationship
```
create(:Person{name:"Dilip"}) - [:loves]->(:Technology{name:"Java"})
```

## How do you use Neo4j?

- Create Model
- Load Data (CSV)
- Query
  - Neo4j comes with its own web app to query against

## Installing neo4j  

```
brew install neo4j
```

## How to Connect to neo4j

- Connect to the below url from the browser.

``
http://localhost:7474/browser/
``

- Credentials for connecting for the first time

```
username : neo4j
password : neo4j
```

## Querying neo4j using Cypher

- Cypher queries are based on **Patterns**
  - **Patterns** in cypher use **AsciiArt**

- A simple select query in Cypher will look like below.

```
MATCH
  (p1:Person) - [:Drives] -> (c:Car) -> [:OWNED_BY] -> (p2:Person) <- [:LOVES]-(p1)
RETURN
  p1
```
### AsciiArt for Nodes

#### Alias
- **p1** -> alias

#### Label

- **:Person** -> is a label give to a  node

### Nodes can have Properties

- The node below has the property **name**

```
(p1:Person {name : 'Dilip'})
```

### AsciiArt for RelationShips

#### Relationship Representation

- The relationship is represented using hyphens or square brackets

```
--> or -[h:HIRED]->
```

#### Direction of Relationship

- The direction of the relationship is represented using the lesser than or greater than

```
<>
```

- Example

```
(p1)-[:HIRED]->(p2) or (p1)<-[:HIRED]-(p2)
```

#### RelationShip properties

```
[h:HIRED {type: 'fulltime'}]->
```

### Hands on Neo4j

- Some of the handy Keywords are given below

  - CREATE -> Creates the node, relationship
  - MATCH -> Similar to  SELECT and WHERE combination.
  - RETURN -> Returns the resultset
  - WHERE -> Provide a filter in the selected result
  - SET -> Set Properties to a Node
  - DETACH DELETE -> Used to detach a relationship and delete the node

#### Creating a RelationShip

-  A simple node relationship can be formed like below

```
CREATE(p:Person{name:'Dilip'})-[:Loves]->(pe:Pet{name:'Scooby'})
```

### Ensuring Uniqueness

```
CREATE CONSTRAINT ON (p:Person)
ASSERT p.name is UNIQUE;

CREATE CONSTRAINT ON (p1:Pet)
ASSERT p1.name is UNIQUE;
```

#### Adding new relationships to the existing nodes

- **pe** here refers to the pet
- **p** here refers to the person
- **c1** here refers to the person

### Merge Relationships using Alias

- Select the node using Match and then create a relationship using the alias.

```
MATCH (p:Person { name: 'Dilip' }),(pe:Pet { name: 'Scooby'})
MERGE(p)-[:Loves]-(pe)
MERGE(pe)-[:Loves]->(p)
```

- Some more examples below

```
MERGE(pe)-[:Lives_with]->(p)

MERGE(p)-[:Lives_In]->(c1:City{name:'AppleValley'})

MERGE(pe)-[:Lives_In]->(c1)

```

#### A simple query to select a record from the DB

- A simple query  to match a record.
  - The below query does this **Return the pet which Dilip Loves**

- Approach 1

#### MATCH, RETURN
```
MATCH(p1:Person {name:'Dilip'})-[:Loves]->(p:Pet) RETURN p
```

The below returns the pet with the following properties
  - Person name as **Dilip**
  - Relationship is **Loves**

- A simple query to match the city

```
MATCH (p1:Person{name :'Dilip'})-[:Lives_In]->(c:City) return c
```

#### MATCH, WHEERE,  RETURN

```
MATCH
  (p1:Person)-[:Lives_In]->(c:City)
WHERE  
  p1.name='Dilip'
return
  c
```

#### MATCH, WHEERE, SET, RETURN

- The **SET** Command below sets additional properties to the returned result.

```
MATCH
  (p1:Person)-[:Lives_In]->(c:City)
WHERE  
  p1.name='Dilip'
SET
  c.name='AppleValley'
return
  c
```

#### DELETE ALL THE Data

- The below command deletes all the data in the DB.

```
MATCH (n)
DETACH DELETE n
```
#### MERGE, SET

```
MERGE (p2:Person {name: 'Aish' })
ON CREATE SET
  p2.email = 'abc'
MERGE (p2) -[:Loves]-> (p1)
```
