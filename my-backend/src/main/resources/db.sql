drop database if exists seat_renting;
create database seat_renting character set latin1 collate latin1_spanish_ci;
use seat_renting;

CREATE TABLE IF NOT EXISTS MOBILITYTYPES
(
    id          bigint AUTO_INCREMENT,
    name        varchar(100),
    description varchar(300),
    PRIMARY KEY (id)
);

INSERT INTO MOBILITYTYPES VALUES
(1, 'Kickscooter','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),
(2, 'Scooter','Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),
(3, 'Car','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),
(4, 'Luxury car','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?');

CREATE TABLE IF NOT EXISTS FUELSOURCES
(
    id          bigint AUTO_INCREMENT,
    name        varchar(100),
    description varchar(300),
    PRIMARY KEY (id)
);

INSERT INTO FUELSOURCES VALUES
(1, 'Electric','Lorem ipsum dolor sit, amet consectetur adipisicing elit. int sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),
(2, 'TGI','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),
(3, 'Gasoline','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),
(4, 'Diesel','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?');


CREATE TABLE IF NOT EXISTS VEHICLES
(
    id              		bigint AUTO_INCREMENT,
    fk_mobilitytype_id  	bigint,
    name            		varchar(100),
    description     		varchar(300),
    pricePerDay   			double,
    passengers              int,
    gearbox                 varchar(50),
    image           		varchar(100),
    PRIMARY KEY (id),
    FOREIGN KEY (fk_mobilitytype_id) REFERENCES MOBILITYTYPES (id)
);

INSERT INTO VEHICLES VALUES
(1, 3, 'Mii', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut?', 30, 4, 'Manual', '1.jpg'),
(2, 3, 'Mii electric', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita libero porro incidunt error recusandae possimus necessitatibus iure assumenda suscipit? Ratione!', 30, 4, 'Automatic', '2.jpg'),
(3, 3, 'Ibiza', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Id dolorum aspernatur suscipit aut rem earum perferendis laboriosam architecto, numquam voluptates officia nulla quam! Praesentium, earum iure cumque veniam perspiciatis id illum culpa ipsum repudiandae molestias eaque minus nostrum, quo ut?', 40, 5, 'Manual', '3.jpg'),
(4, 3, 'León', 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Commodi, necessitatibus facere debitis odit dolor animi laboriosam dolorum facilis eaque nulla illo cupiditate deleniti sit? Ratione reiciendis hic doloribus illum labore laboriosam ut, dolorum inventore est aperiam quis omnis aut architecto.', 60, 5, 'Manual', '4.jpg'),
(5, 3, 'Nuevo León', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis! Aliquid, modi sint! Molestiae, minima mollitia aliquid velit quidem pariatur vero reprehenderit voluptatibus sunt ex ullam adipisci cupiditate eveniet corporis non dolore laudantium accusantium.',50, 5, 'Automatic', '5.jpg'),
(6, 3, 'León Sportstourer', 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Optio labore dolor molestiae dolores at voluptates, ad rerum culpa veritatis. Rem adipisci voluptatibus rerum. Aliquam quia recusandae distinctio ut.',65, 5, 'Automatic','6.jpg'),
(7, 3, 'Nuevo León Sportstourer', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa impedit laborum consequuntur ut!',60, 5, 'Automatic','7.jpg'),
(8, 3, 'Arona', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Rerum quas accusamus nobis illo, autem illum nisi, distinctio corporis dolore reprehenderit nam voluptatum rem? Fugiat, deleniti voluptatum! Minus cupiditate voluptatibus totam beatae ducimus velit obcaecati, mollitia sint illum.',55, 5, 'Manual', '8.jpg'),
(9, 3, 'Alhambra', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequuntur, nam pariatur? Minus, praesentium itaque ex quam mollitia dicta obcaecati necessitatibus!',80, 7, 'Automatic', '9.jpg'),
(10,3, 'Ateca', 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fuga reiciendis, veritatis maiores ex numquam voluptatum facere natus a accusamus nesciunt alias nulla tempora quaerat autem laudantium quibusdam quo excepturi velit laboriosam obcaecati qui, optio illo explicabo.',70, 5, 'Manual','10.jpg'),
(11,3, 'Nuevo Ateca', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis iure molestias, recusandae dolorum officiis quia ex architecto, deserunt tempore laudantium quae veritatis provident corrupti nihil sequi delectus dolores quas accusamus.',75, 5, 'Automatic','11.jpg'),
(12,3, 'Tarraco', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus iure a quod cum. Voluptatum repellat similique facilis nisi libero corrupti natus repellendus, sit, eaque quis eos ut odit molestias voluptas.', 90, 7, 'Automatic','12.jpg'),
(13,1, 'SEAT MÓ eKickscooter 25', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita, sunt laboriosam saepe earum nemo ullam veniam corrupti ratione dolorum eaque, distinctio sed maxime sequi ea provident amet aut optio atque!', 16, 1, null, '13.jpg'),
(14,1, 'SEAT MÓ eKickscooter 65', 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Optio labore dolor mo...',18, 1, null, '14.jpg'),
(15,2, 'SEAT MÓ eScooter 125', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus iure a quod cum. Voluptatum repellat similique facilis nisi libero co', 25, 2, 'Automatic', '15.jpg'),
(16,4, 'CUPRA Ateca', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis!', 260, 5, 'Automatic','16.jpg'),
(17,4, 'CUPRA Formentor', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis!',300, 5, 'Automatic','17.jpg'),
(18,4, 'Nuevo CUPRA León', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis!', 220, 5, 'Automatic','18.jpg'),
(19,4, 'Nuevo CUPRA León Sportstourer', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis!',250, 5, 'Automatic', '19.jpg');

CREATE TABLE IF NOT EXISTS VEHICLES_FUELSOURCES
(
    fk_fuelsource_id  	bigint,
    fk_vehicle_id  		bigint,
    FOREIGN KEY (fk_fuelsource_id) REFERENCES FUELSOURCES (id),
    FOREIGN KEY (fk_vehicle_id) REFERENCES VEHICLES (id)
);

INSERT INTO VEHICLES_FUELSOURCES VALUES
(3,1),
(1,2),
(2,3),
(3,3),
(4,3),
(2,4),
(3,4),
(4,4),
(3,5),
(4,5),
(2,6),
(3,6),
(4,6),
(3,7),
(4,8),
(2,9),
(3,9),
(4,9),
(3,10),
(4,10),
(3,11),
(4,11),
(3,12),
(4,12),
(1,13),
(1,14),
(1,15),
(3,16),
(4,16),
(3,17),
(4,17),
(3,18),
(4,18),
(3,19),
(4,19);

CREATE TABLE IF NOT EXISTS CLIENTS
(
    id               bigint AUTO_INCREMENT,
    name           	 varchar(100),
    lastname         varchar(100),
    email            varchar(100),
    PRIMARY KEY (id)
);

INSERT INTO CLIENTS VALUES
(1, 'Pablo','Garcia','Garcia@seat.es'),
(2, 'Oscar','Garcia','OGarcia@seat.com'),
(3, 'Miguel','Pablos','mdpablos@seat.com');

CREATE TABLE IF NOT EXISTS BOOKINGS
(
    id              bigint AUTO_INCREMENT,
    fk_client_id	bigint,
    fk_vehicle_id	bigint,
    checkIn         date,
    checkOut        date,
    totalPrice      double,
    PRIMARY KEY (id),
    FOREIGN KEY (fk_vehicle_id) REFERENCES VEHICLES (id),
    FOREIGN KEY (fk_client_id) REFERENCES CLIENTS (id)
);

INSERT INTO BOOKINGS VALUES
(1, 1, 1, '2020-09-10','2020-09-14',400),
(2, 1, 2, '2020-10-10','2020-10-14',200);

CREATE TABLE IF NOT EXISTS LOGINS
(
    id      		bigint AUTO_INCREMENT,
    fk_client_id  	bigint UNIQUE,
    username 		varchar(100) UNIQUE,
    password 		varchar(100),
    role            varchar(100),
    enabled         tinyint(1),
    PRIMARY KEY (id),
    FOREIGN KEY (fk_client_id) REFERENCES CLIENTS (id)
);

INSERT INTO LOGINS VALUES
(1, 1, 'Garcia1989','1234','ROLE_CLIENT',1),
(2, 2, 'Oscar2000','1234','ROLE_CLIENT',1),
(3, 3, 'Miguel','1234','ROLE_CLIENT',1);