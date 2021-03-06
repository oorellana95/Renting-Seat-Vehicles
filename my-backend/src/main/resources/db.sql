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

CREATE TABLE IF NOT EXISTS VEHICLES
(
    id              		bigint AUTO_INCREMENT,
    fk_mobilitytype_id  	bigint,
    name            		varchar(100),
    description     		varchar(500),
    specificDescription     varchar(500),
    pricePerDay   			double,
    passengers              int,
    gearbox                 varchar(50),
    image           		varchar(100),
    PRIMARY KEY (id),
    FOREIGN KEY (fk_mobilitytype_id) REFERENCES MOBILITYTYPES (id)
);


INSERT INTO VEHICLES VALUES
(1, 3, 'Mii', 'Do ullamco sit ad ex minim ullamco quis nulla cillum labore tempor culpa aute. Tempor ex anim aliquip adipisicing aute adipisicing ea est non aliquip fugiat. Cillum excepteur fugiat voluptate enim elit. Eiusmod velit quis nostrud consequat nisi voluptate duis consequat amet nostrud reprehenderit. Enim eu consequat eu occaecat adipisicing officia.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut?Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident opti sapiente aspernatur dolorum ullam Illo rem ex labore ut?', 30, 4, 'Manual', '1.jpg'),
(2, 3, 'Mii electric', 'Anim culpa cupidatat dolore enim cillum velit cupidatat eu ad laborum nisi aute laborum ea. Eiusmod in ad enim ut in magna dolore minim nisi officia nisi excepteur est eiusmod. Reprehenderit occaecat sit et mollit deserunt velit. Fugiat anim sunt minim quis dolor. Non reprehenderit incididunt magna cupidatat Lorem ipsum.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita libero porro incidunt error recusandae possimus Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut?necessitatibus iure assumenda suscipit? pti sapiente aspernatur pti sapiente aspernatur dolorum ullam dolorum ullam Ratione!', 30, 4, 'Automatic', '2.jpg'),
(3, 3, 'Ibiza', 'Nulla ullamco sint et duis magna. Deserunt duis adipisicing ad et excepteur consectetur ea aliquip et sit et duis commodo. Non do est proident proident.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Id dolorum aspernatur suscipit aut rem earum perferendis laboriosam architecto, numquam voluptates officia nulla quam! Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut?Praesentium, earum iure cumque veniam perspiciatis id illum culpa ipsum repudiandae molestias eaque minus nostrum, quo ut?', 40, 5, 'Manual', '3.jpg'),
(4, 3, 'León', 'Eu veniam dolor eu aliquip. Laborum amet exercitation adipisicing deserunt fugiat minim nulla reprehenderit. Ex fugiat consequat labore laborum. Enim id labore cillum deserunt ipsum officia laboris ea fugiat. Proident minim enim voluptate adipisicing amet proident consequat minim magna deserunt pariatur incididunt nostrud.', 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Commodi, necessitatibus facere debitis odit dolor animi laboriosam dolorum facilis eaque nulla illo cupiditate deleniti sit? Ratione reiciendis hic doloribus illum labore Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut?laboriosam ut, dolorum inventore est aperiam quis omnis aut architecto.', 60, 5, 'Manual', '4.jpg'),
(5, 3, 'Nuevo León', 'Minim irure non exercitation dolor. Reprehenderit qui esse culpa ex in pariatur incididunt id irure in duis ipsum. Lorem non duis qui eiusmod proident magna. Elit qui laboris laboris et veniam ad sit reprehenderit fugiat et mollit ut.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis! Aliquid, modi sint! Molestiae, minima mollitia aliquid velit quidem pariatur vero reprehenderit voluptatibus sunt ex ullam adipisci cupiditate eveniet corporis non dolore Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut? laudantium accusantium.',50, 5, 'Automatic', '5.jpg'),
(6, 3, 'Nuevo León Sportstourer', 'Nulla amet reprehenderit dolor officia sunt non aliqua duis ex ipsum irure. Proident laborum cupidatat occaecat cupidatat aliqua eu. Eu ut minim commodo nostrud amet sunt occaecat Lorem laboris eu excepteur.', 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Optio labore dolor molestiae dolores at voluptates, ad rerum culpa veritatis. Rem adipisci voluptatibus rerum. Aliquam quia Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. pti sapiente aspernatur dolorum ullamIllo rem ex labore ut? recusandae distinctio ut.',65, 5, 'Automatic','6.jpg'),
(7, 3, 'Nuevo León Sportstourer', 'Id sit occaecat veniam ex officia non laboris. Culpa incididunt consectetur aliqua dolor anim Lorem est. Ut aute ex officia esse dolor veniam exercitation nostrud voluptate. Sit nisi est quis ullamco adipisicing adipisicing culpa ipsum commodo Lorem esse officia laborum elit. In ex ea aliquip cupidatat.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa impedit Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut? laborum consequuntur ut!',60, 5, 'Automatic','7.jpg'),
(8, 3, 'Arona', 'Est velit quis nulla magna excepteur id cillum qui aute commodo nulla. Adipisicing non sit laboris dolore. Officia Lorem consequat non consectetur pariatur et non occaecat reprehenderit laborum irure in. Pariatur anim deserunt adipisicing labore aute enim amet eiusmod pariatur commodo duis.','Lorem ipsum dolor sit amet consectetur adipisicing elit. Rerum quas accusamus nobis illo, autem illum nisi, distinctio corporis dolore reprehenderit nam voluptatum rem? Fugiat, deleniti voluptatum! Minus cupiditate voluptatibus totamCum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut? beatae ducimus velit obcaecati, mollitia sint illum.',55, 5, 'Manual', '8.jpg'),
(9, 3, 'Alhambra', 'Nisi dolore ea duis cillum officia aliqua ad aliquip officia mollit ea esse tempor duis. Voluptate culpa laboris est minim irure occaecat culpa. Ullamco cupidatat sit sunt reprehenderit veniam aute voluptate laborum esse. Laborum do incididunt reprehenderit dolor non irure dolore ea labore. Enim reprehenderit nulla duis consectetur anim non dolore adipisicing in labore. Cillum nostrud ipsum dolore aliquip veniam veniam amet esse tempor est sunt minim.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequuntur, nam pariatur? Minus, praesentium itaque ex quam mollitia dicta obcaecati Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut? pti sapiente aspernatur dolorum ullampti sapiente aspernatur dolorum ullam necessitatibus!',80, 7, 'Automatic', '9.jpg'),
(10,3, 'Ateca', 'Consequat do cillum do adipisicing adipisicing est proident cillum id consequat ad commodo sit anim. Ipsum excepteur commodo cupidatat est fugiat irure adipisicing nulla culpa et amet velit. Excepteur tempor ipsum veniam ipsum Lorem in ipsum reprehenderit nisi labore aliqua. Occaecat enim sint excepteur cupidatat do nisi ex ipsum ut do reprehenderit adipisicing nulla voluptate. Enim cupidatat amet velit do do labore tempor ad incididunt eu.', 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fuga reiciendis, veritatis maiores ex numquam voluptatum facere natus a accusamus nesciunt alias nulla Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut? tempora quaerat autem laudantium quibusdam quo excepturi velit laboriosam obcaecati qui, optio illo explicabo.',70, 5, 'Manual','10.jpg'),
(11,3, 'Nuevo Ateca', 'Aute aliqua enim in voluptate. Ullamco anim laborum laborum ut excepteur ipsum. Esse laborum duis pariatur sint irure officia. Occaecat aute adipisicing mollit fugiat sint Lorem aliqua esse consequat occaecat proident consequat adipisicing. Dolore velit in id nostrud exercitation culpa aute nulla magna. Amet exercitation nisi aliquip ipsum.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis iure molestias, recusandae dolorum officiis quia ex architecto, deserunt tempore laudantium quae veritatis provident Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut? corrupti nihil sequi delectus dolores quas accusamus.',75, 5, 'Automatic','11.jpg'),
(12,3, 'Tarraco', 'Proident amet amet est officia nulla eu qui commodo duis nulla eu incididunt officia veniam. Deserunt eu ipsum ex voluptate veniam sunt nostrud. Velit cillum in exercitation sunt elit tempor aliqua voluptate duis sunt ad dolore. Dolor non mollit consectetur est.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus iure a quod cum. Voluptatum repellat similique facilis nisi libero corrupti natus repellendus, sit, eaque quis eos ut odit molestias  Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore pti sapiente aspernatur dolorum ullam provident. Illo rem ex labore ut?voluptas.', 90, 7, 'Automatic','12.jpg'),
(13,1, 'SEAT MÓ eKickscooter 25', 'Ad mollit ipsum culpa culpa culpa cupidatat consectetur sint in laborum commodo cupidatat sunt. Occaecat esse voluptate consequat aute magna ad tempor id Lorem. Aliquip nisi pariatur exercitation et pariatur excepteur anim minim enim. Pariatur do amet occaecat mollit duis sunt magna dolore.', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita, sunt laboriosam saepe earum nemo ullam veniam corrupti ratione dolorum eaque, distinctio sed maxime sequi ea provident amet aut Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut? optio atque!', 16, 1, null, '13.jpg'),
(14,1, 'SEAT MÓ eKickscooter 65', 'Ullamco culpa sint cillum quis irure anim ea deserunt culpa. Incididunt nulla id cupidatat sit pariatur et duis id anim minim nisi consequat. Duis in ut Lorem laborum esse mollit. Esse sint laborum occaecat ea. Laboris eiusmod laborum nisi elit quis occaecat laborum est ut commodo.', 'Lorem ipsum dolor, sit amet consectetur adipisicing elitcing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa. Optio labore dolor mo cing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis elimaiores dolore provident. Illo rem ex labore ut? gendi ipsa',18, 1, null, '14.jpg'),
(15,2, 'SEAT MÓ eScooter 125', 'Sit duis nostrud sint ad mollit occaecat ullamco enim nostrud amet ea. Adipisicing id minim elit duis laboris eiusmod mollit dolor. Ea fugiat proident sit occaecat cupidatat incididunt laboris eu non.', 'Lorem ipsum dolor sit amet consectetur adipisicing elicing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsat. Temporibus iure a quod cumcing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa maiores dolore provident. Illo rem ex labore ut?  Voluptatum repellat similique facilis nisi libero co', 25, 2, 'Automatic', '15.jpg'),
(16,4, 'CUPRA Ateca', 'Excepteur velit laborum eu proident fugiat ullamco ea voluptate dolore eu. Velit nulla adipisicing excepteur magna deserunt sint culpa do eiusmod nulla sint exercitation. Enim cillum veniam anim fugiat adipisicing anim sit. Quis duis tempor adipisicing culpa. Culpa voluptate et do consectetur mollit. Aliquip ullamco officia veniam veniam consectetur commodo pariatur amet Lorem. Proident esse pariatur minim pariatur Lorem deserunt nostrud nostrud minim est veniam sit anim sint.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Adcing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa id facilis nesciunt animi perferendiscing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa! maiores dolore provident. Illo rem ex labore ut? ', 260, 5, 'Automatic','16.jpg'),
(17,4, 'CUPRA Formentor', 'Cupidatat Lorem laborum aliquip labore adipisicing in proident eiusmod reprehenderit exercitation ea qui. Est fugiat fugiat proident occaecat qui excepteur cillum sunt eiusmod. Duis officia cupidatat fugiat officia id aute amet reprehenderit reprehenderit reprehenderit. Excepteur nostrud mollit esse ea nulla non ullamco duis exercitation voluptate proident.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Adcing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa id facilis nesciunt animi perferendiscing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa! maiores dolore provident. Illo rem ex labore ut? ',300, 5, 'Automatic','17.jpg'),
(18,4, 'Nuevo CUPRA León', 'Ad nisi irure deserunt voluptate laboris elit fugiat sunt. Adipisicing sunt in sint ullamco ea aliqua culpa mollit consectetur fugiat sit. Aliquip exercitation occaecat cillum quis do elit enim fugiat magna nisi. Quis ad voluptate elit voluptate mollit ea adipisicing amet.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Adcing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa id facilis nesciunt animi perferendis!  cing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa maiores dolore provident. Illo rem ex labore ut? ' , 220, 5, 'Automatic','18.jpg'),
(19,4, 'Nuevo CUPRA León Sportstourer', 'Ipsum culpa nostrud ad voluptate. Eiusmod aute duis incididunt incididunt proident nostrud tempor aute et fugiat occaecat. Dolore aliqua tempor elit ipsum pariatur enim ad ullamco commodo exercitation exercitation ullamco cillum minim. Officia magna cupidatat esse esse eiusmod nostrud cupidatat aute pariatur consectetur fugiat qui velit. Ea id irure enim non in dolore.', 'Lorem ipsum dolor sit amet consectetur adipisicing elitcing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa. Ad id facilis nesciunt animi perferendis! cing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi maiores dolore provident. Illo rem ex labore ut?  ipsa',250, 5, 'Automatic', '19.jpg');

CREATE TABLE IF NOT EXISTS OFFERS
(
    id              bigint AUTO_INCREMENT,
    name            varchar(50),
    description     varchar(150),
    startDate       date,
    endDate         date,
    cumulative      boolean,
    type            varchar(50),
    quantity        double,
    PRIMARY KEY (id)
);

INSERT INTO OFFERS VALUES
(1, '10% off Luxury cars!','0.1*(Avg Price) to luxury cars', '2020-10-01','2020-12-31', true, 'proportional', 0.1),
(2, '10e off All New Leon!','Avg Price minus 10e', '2020-09-01','2020-12-31', true, 'absolute', 10),
(3, '5e off per day Scooters!','Avg Price minus 5e', '2020-09-01','2020-12-31', true, 'absolute', 5),
(4, '5% off Seat cars!','0.05*Avg Price', '2020-09-01','2020-12-31', true, 'proportional', 0.05),
(5, '10e off per day Mii cars!','Price minus 10e', '2020-09-01','2020-12-31', true, 'absolute', 10),
(6, '20% off Atecas','0.2*Avg Price', '2020-10-01','2020-12-31', false, 'proportional', 0.2),
(7, '30e off per day Tarraco','Avg Price minus 30e', '2020-10-01','2020-12-31', false, 'absolute', 30);

CREATE TABLE IF NOT EXISTS OFFERS_VEHICLES
(
    fk_offer_id    bigint,
    fk_vehicle_id  bigint,
    FOREIGN KEY (fk_offer_id) REFERENCES OFFERS (id),
    FOREIGN KEY (fk_vehicle_id) REFERENCES VEHICLES (id)
);

INSERT INTO OFFERS_VEHICLES VALUES
(2, 5),
(2, 6),
(2, 18),
(2, 19),
(3, 13),
(3, 14),
(3, 15),
(5, 1),
(5, 2),
(6, 10),
(6, 11),
(7, 12);

CREATE TABLE IF NOT EXISTS OFFERS_MOBILITYTYPES
(
    fk_offer_id  	bigint,
    fk_mobilitytype_id  		bigint,
    FOREIGN KEY (fk_offer_id) REFERENCES OFFERS (id),
    FOREIGN KEY (fk_mobilitytype_id) REFERENCES MOBILITYTYPES (id)
);

INSERT INTO OFFERS_MOBILITYTYPES VALUES
(4, 3),
(1, 4);

CREATE TABLE IF NOT EXISTS BOOKINGS
(
    id              bigint AUTO_INCREMENT,
    fk_vehicle_id	bigint,
    checkIn         date,
    checkOut        date,
    totalPrice      double,
    client          varchar(100),
    email           varchar(100),
    PRIMARY KEY (id),
    FOREIGN KEY (fk_vehicle_id) REFERENCES VEHICLES (id)
);

INSERT INTO BOOKINGS VALUES
(1, 1, '2020-09-10','2020-09-14',400, 'Oscar Orellana Gonzalez', 'oscar@gmail.com'),
(2, 2, '2020-10-10','2020-10-14',200, 'Kevin Nerluzs', 'kevin@gmail.com');