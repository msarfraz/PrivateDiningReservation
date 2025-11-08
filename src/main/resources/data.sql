-- initialize restaurants
INSERT INTO public.restaurant(
	id,name, location)
	VALUES
	(1, 'Melbourne Restaurant', ST_GeomFromText('POINT(-37.885883 145.012627)')),
    (2, 'Popular Restaurant', ST_GeomFromText('POINT(-37.8887193813491 145.01536307180643)')),
    (3, 'Faraway Restaurant', ST_GeomFromText('POINT(-47.84420705982205 244.874212280217)'))
	ON CONFLICT (id) DO NOTHING;

-- initialize rooms
insert into room(id, name, room_type, min_capacity, max_capacity, min_spend, restaurant_id)
values(1, 'room 1', 'Hall', 5, 10, 100, 1),
(2,'big room', 'RoofTop', 5, 20, 100, 1),
(3,'privacy room', 'PrivateRoom', 1, 5, 100, 1),
(4,'room 2', 'Hall', 5, 10, 100, 2),
(5,'big room', 'RoofTop', 5, 20, 100, 2),
(6,'privacy room', 'PrivateRoom', 1, 5, 100, 2),
(7,'room 3', 'Hall', 5, 10, 100, 3),
(8,'big room', 'RoofTop', 5, 20, 100, 3),
(9,'privacy room', 'PrivateRoom', 1, 5, 100, 3)
ON CONFLICT (id) DO NOTHING;