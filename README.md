

```mermaid
graph TD
    %% cocktail-ear als Gesamtkasten
    subgraph cocktail-ear
        style cocktail-ear fill:#f0f0f0,stroke:#000,stroke-width:2

        %% Module: client-web
        client-web
        style client-web fill:#ffcccc,stroke:#000,stroke-width:1

        %% Module: cocktail
        subgraph Cocktail ["Cocktail"]
            cocktail-ejb
            cocktail-api
            style cocktail-ejb fill:#ccffcc,stroke:#000,stroke-width:1
            style cocktail-api fill:#ccccff,stroke:#000,stroke-width:1
            cocktail-ejb --> cocktail-api
        end

        %% Module: fridge
        subgraph Fridge ["Fridge"]
            fridge-ejb[fridge-ejb]
            fridge-api[fridge-api]
            style fridge-ejb fill:#ccffcc,stroke:#000,stroke-width:1
            style fridge-api fill:#ccccff,stroke:#000,stroke-width:1
            fridge-ejb --> fridge-api
        end
        fridge-ejb --> cocktail-api
        %% fridge-ejb --> Cocktail
        %% Fridge --> cocktail-api
        %%Fridge --> Cocktail

        %% Gemeinsames Model
        cocktail-model[cocktail-model]
        style cocktail-model fill:#fff2cc,stroke:#000,stroke-width:1

        %% Verbindungen zu client-web
        client-web --> Cocktail
        client-web --> Fridge

        %% Verbindungen zu Model
        cocktail-api --> cocktail-model
        fridge-api --> cocktail-model
    end
