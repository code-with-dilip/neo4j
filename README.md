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
create(:label{prop1:"prop1value"}) - [:relationship]->(:label{prop1:"prop1value"})
```

### Example

#### One Directional Relationship
```
create(:Person{name:"Dilip"}) - [:loves]->(:Technology{name:"Java"})
```

#### BiDirectional Relationship

```
create(:Person{name:"Dilip"}) -> [:loves]->(:Technology{name:"Java"})
```

#### non directional
```
create(:Person{name:"Dilip"}) - [:loves] - (:Technology{name:"Java"})
```
