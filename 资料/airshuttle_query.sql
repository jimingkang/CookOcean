use airshuttle;
desc t_airshuttle_fly_group;
select * from t_airshuttle_fly_group;
select * from t_airshuttle_driver;
desc t_airshuttle_driver;
update  t_airshuttle_driver set driving_license_url='http://car0.autoimg.cn/upload/2014/8/11/t_20140811225329553510411.jpg' where id>1;
select * from t_airshuttle_driver_car;
insert into t_airshuttle_book_driver_process(book_driver_id, review_process_id,process_result_desc) select id,1,'driver accept ' from t_airshuttle_user_book_driver where id>=1;
select * from t_airshuttle_user_book_driver;
update t_airshuttle_user_book_driver set book_price=10 where id>1;
update t_airshuttle_reception_air set price=10 where id>1; 

select au.book_time, au.user_id, au.driver_id, au.book_price,au.book_number_person, au.pick_up_time, au.status,ar.reception_city, ar.reception_school, ar.reception_airport from t_airshuttle_user_book_driver au left join t_airshuttle_reception_air ar on(au.reception_air_id =ar.id)   
where au.user_id=1 limit 1,3;


select * from  t_airshuttle_book_driver_process;

delete from   t_airshuttle_user_book_driver where id>=1;
delete from   t_airshuttle_book_driver_process where id>=1;
update  t_airshuttle_order set user_id=1 where id>=1;
 
select *  from   t_airshuttle_book_driver_process where id>=1;
update  t_airshuttle_book_driver_process set book_driver_id=22 where id=15;

update  t_airshuttle_book_driver_process  set review_process_id=0 where id>=1;



select * from t_airshuttle_user_book_driver;
select * from t_airshuttle_order;
insert into t_airshuttle_order(designation_number,create_time,user_id,book_id,driver_id,reception_air_id,book_number_person,pick_up_time,book_price)
select concat('Order_',DATE_FORMAT(now(),'%y%m%d%H%l%S')),now(),user_id,id,driver_id,reception_air_id,book_number_person,pick_up_time,book_price 
from t_airshuttle_user_book_driver ; 
select * from t_airshuttle_order_process;
delete from t_airshuttle_order  where id>=1;
delete  from t_airshuttle_order_process  where id>=1;

select * from t_airshuttle_reception_air;


select ar.reception_city, ar.reception_school, ap.id bookDriverProcessId , 
ap.review_process_id, ap.process_result_desc, ap.MODIFY_TIME, au.id, au.book_time, 
au.user_id, au.driver_id, au.book_price,au.book_number_person, au.pick_up_time, au.status,au.reception_air_id
  from t_airshuttle_reception_air ar   
inner join t_airshuttle_user_book_driver au on(ar.id=au.reception_air_id )  
 inner join  t_airshuttle_book_driver_process ap on(au.id=ap.book_driver_id) 
where au.user_id=1  and (ap.book_driver_id, ap.review_process_id) in (select  app.book_driver_id, max(app.review_process_id) 
 from t_airshuttle_book_driver_process app group by app.book_driver_id);

	

insert into t_airshuttle_reception_air 
(CREATE_PERSON,
CREATE_TIME,
MODIFY_PERSON, 
reception_city,
reception_school, 
reception_airport, 
driver_id,
car_id, 
open_time, 
price,load_seatNum) values(1, now(),1, 'NY', 'NYC', 'KEN', 2004, 4, 'Mon-Fri 1:pm-8:pm', 10, 4);

 insert into t_airshuttle_driver
 ( CREATE_PERSON, CREATE_TIME, MODIFY_PERSON, realName,idCard, telephone, driving_license_url, 
Drivers_license_url, official_photot_url,status)values (
  1,now(), 1, '谢云0', 511602198604171914, 15928687165, 'http://maimode.iteye.com/blog/DrivingLicenseUrl', 'http://maimode.iteye.com/blog/DriversLicenseUrl', 'http://maimode.iteye.com/blog/OfficialPhototUrl', 1);



select ar.id,ar.CREATE_PERSON, ar.CREATE_TIME,ar.MODIFY_PERSON, ar.reception_city,
ar.reception_school, ar.reception_airport, ar.driver_id,car_id, ar.open_time, 
ar.price,ar.load_seatNum, ad.realName,ad.driving_license_url  
from t_airshuttle_reception_air ar inner join t_airshuttle_driver ad on (ar.driver_id=ad.id )
 where ar.reception_school='NYC' 

/*
--
--delimiter |
create trigger after_book_driver_process_trigger after insert on after_book_driver_process_trigger  for each row 
begin
 IF new.review_process_id = 1 THEN
   insert into t_airshuttle_book_driver_process(book_driver_id, review_process_id,process_result_desc) select id,1,'driver accept ' from t_airshuttle_user_book_driver where id>=1;
 end if;
end; 
|

delimiter ;
*/
