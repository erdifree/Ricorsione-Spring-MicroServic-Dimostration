

 INSERT INTO attivita_padre (id)
    VALUES(1),(2),(3),(4),(5),(6);


    INSERT INTO attivita (alias,lavorata,attivita_padre)
    VALUES('ACTIVITY1',false,null),('ACTIVITY2',false,1),('ACTIVITY3',false,2),('ACTIVITY4',false,3),('ACTIVITY5',false,3),('ACTIVITY6',false,4) ;