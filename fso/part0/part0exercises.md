#FIRST SUBMISSION


```mermaid

sequenceDiagram
    Browser->>+Server: GET https://studies.cs.helsinki.fi/exampleapp/notes
    Server->>+Browser: HTML document

    Browser-->>-Server: POST https://studies.cs.helsinki.fi/exampleapp/new_note
    Server-->>-Browser: Redirect
    
    Browser->>+Server: GET https://studies.cs.helsinki.fi/exampleapp/notes
    Server->>+Browser: HTML document

```


