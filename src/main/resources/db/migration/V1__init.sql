create table services(
	service_id serial primary KEY ,
	name varchar(50) not null,
	description text not null,
	image_url text not null
);

INSERT INTO services (name, description, image_url)
VALUES
('Уборка офисов',
'Комплексная уборка офисных помещений, включающая в себя вынос мусора, протирку поверхностей, чистку ковров и уборку санузлов.',
'https://avatars.mds.yandex.net/i?id=6c9ebcd1a60b140ede4d5a1a16256d67_l-6489726-images-thumbs&n=13'),

('Генеральная уборка квартир',
'Полная уборка квартиры с мытьем окон, чисткой всех поверхностей, полов и мебели, а также дезинфекцией санузлов и кухни.',
'https://colodu.club/uploads/posts/2022-10/1666187726_7-colodu-club-p-uborka-v-komnate-dizain-pinterest-7.jpg'),

('Уборка после ремонта',
'Удаление строительного мусора, пыли и пятен после ремонта. Полная очистка помещений, включая окна, полы и мебель.',
'https://e-niemann.de/wp-content/uploads/2021/12/baureinigung-luebeck-scaled.webp'),

('Мытье окон',
'Профессиональная мойка окон и витрин с использованием специализированного оборудования и безопасных моющих средств.',
'https://cleanfox-msk.ru/wp-content/uploads/2023/02/shutterstock_1384705523-1920w1-1.jpg'),

('Уборка промышленных помещений',
'Чистка производственных площадей, складов и цехов с учетом специфики бизнеса и использования профессиональных средств.',
'https://infohale.ro/wp-content/uploads/2021/09/professional-cleaner-wearing-protection-uniform-cleaning-floor-production-plant-scaled.jpg');
