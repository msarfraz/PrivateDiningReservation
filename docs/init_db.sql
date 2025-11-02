-- initialize restaurants
INSERT INTO public.restaurant(
	name, location)
	VALUES ('Melbourne Restaurant', ST_GeomFromText('POINT(-37.885883 145.012627)'));

INSERT INTO public.restaurant(
	name, location)
	VALUES ('Popular Restaurant', ST_GeomFromText('POINT(-37.8887193813491 145.01536307180643)'));
INSERT INTO public.restaurant(
	name, location)
	VALUES ('Faraway Restaurant', ST_GeomFromText('POINT(-47.84420705982205 244.874212280217)'));

-- initialize rooms
insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('room 1', 'Hall', 5, 10, 100, 1);

insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('big room', 'RoofTop', 5, 20, 100, 1);

insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('privacy room', 'PrivateRoom', 1, 5, 100, 1);

insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('room 2', 'Hall', 5, 10, 100, 2);

insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('big room', 'RoofTop', 5, 20, 100, 2);

insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('privacy room', 'PrivateRoom', 1, 5, 100, 2);

insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('room 3', 'Hall', 5, 10, 100, 3);

insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('big room', 'RoofTop', 5, 20, 100, 3);

insert into room(name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values('privacy room', 'PrivateRoom', 1, 5, 100, 3);