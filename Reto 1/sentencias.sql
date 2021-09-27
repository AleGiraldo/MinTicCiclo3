--Crear la tabla ROOM
CREATE TABLE ROOM
(
    ID NUMBER NOT NULL,
    ROOM VARCHAR2(20) NULL,
    STARS NUMBER NULL,
    CATEGORY_ID NUMBER NULL,
    DESCRIPTION VARCHAR2(4000) NULL,
    PRIMARY KEY (ID)
);

--Modulo GET
SELECT *
FROM ROOM

--Modulo POST
BEGIN
    INSERT INTO ROOM
    (ID, ROOM, STARS, CATEGORY_ID, DESCRIPTION)
    VALUES
    (:id, :room, :stars, :category_id, :description);
    :status_code:=201;
END;

--Modulo PUT
BEGIN
    UPDATE ROOM
    SET ID = :id,
        ROOM = :room, 
        STARS = :stars, 
        CATEGORY_ID = :category_id, 
        DESCRIPTION = :description;
    :status_code:=201;
END;

--Modulo DELETE
BEGIN
    DELETE FROM ROOM
    WHERE ID = :id;
    :status_code:=204;
END;