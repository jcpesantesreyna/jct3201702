USE [jct3]
GO
/****** Object:  Table [dbo].[Citas]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Citas](
	[idcita] [int] IDENTITY(1,1) NOT NULL,
	[idusuario] [int] NULL,
	[idhistoria] [int] NULL,
	[fecha] [date] NULL,
	[idprogramacion] [int] NULL,
 CONSTRAINT [PK_Citas] PRIMARY KEY CLUSTERED 
(
	[idcita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Historia]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Historia](
	[numhistoria] [int] IDENTITY(1,1) NOT NULL,
	[apepat] [varchar](30) NULL,
	[apemat] [varchar](30) NULL,
	[nombres] [varchar](50) NULL,
	[fechanac] [date] NULL,
	[dni] [char](8) NULL,
	[direccion] [varchar](50) NULL,
 CONSTRAINT [PK_Historia] PRIMARY KEY CLUSTERED 
(
	[numhistoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Programacion]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Programacion](
	[idprogramacion] [int] IDENTITY(1,1) NOT NULL,
	[idservicio] [int] NULL,
	[idresposanble] [int] NULL,
	[turno] [char](1) NULL,
	[dialun] [int] NULL,
	[diamar] [int] NULL,
	[diamie] [int] NULL,
	[diajue] [int] NULL,
	[diavier] [int] NULL,
	[diasab] [int] NULL,
	[estado] [bit] NULL,
 CONSTRAINT [PK_Programacion] PRIMARY KEY CLUSTERED 
(
	[idprogramacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Responsable]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Responsable](
	[idresponsable] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](50) NULL,
 CONSTRAINT [PK_Responsable] PRIMARY KEY CLUSTERED 
(
	[idresponsable] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[servicio]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[servicio](
	[idservicio] [int] IDENTITY(3,1) NOT NULL,
	[descripcion] [varchar](50) NULL,
 CONSTRAINT [PK_servicio] PRIMARY KEY CLUSTERED 
(
	[idservicio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Usuario](
	[idusuario] [int] NOT NULL,
	[sesion] [varchar](12) NULL,
	[contrasenia] [varchar](12) NULL,
	[tipo_usuario] [varchar](12) NULL,
	[idresponsable] [int] NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[idusuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Citas]  WITH CHECK ADD  CONSTRAINT [FK_Citas_Historia] FOREIGN KEY([idhistoria])
REFERENCES [dbo].[Historia] ([numhistoria])
GO
ALTER TABLE [dbo].[Citas] CHECK CONSTRAINT [FK_Citas_Historia]
GO
ALTER TABLE [dbo].[Citas]  WITH CHECK ADD  CONSTRAINT [FK_Citas_Programacion] FOREIGN KEY([idprogramacion])
REFERENCES [dbo].[Programacion] ([idprogramacion])
GO
ALTER TABLE [dbo].[Citas] CHECK CONSTRAINT [FK_Citas_Programacion]
GO
ALTER TABLE [dbo].[Citas]  WITH CHECK ADD  CONSTRAINT [FK_Citas_Usuario] FOREIGN KEY([idusuario])
REFERENCES [dbo].[Usuario] ([idusuario])
GO
ALTER TABLE [dbo].[Citas] CHECK CONSTRAINT [FK_Citas_Usuario]
GO
ALTER TABLE [dbo].[Programacion]  WITH CHECK ADD  CONSTRAINT [FK_Programacion_Responsable] FOREIGN KEY([idresposanble])
REFERENCES [dbo].[Responsable] ([idresponsable])
GO
ALTER TABLE [dbo].[Programacion] CHECK CONSTRAINT [FK_Programacion_Responsable]
GO
ALTER TABLE [dbo].[Programacion]  WITH CHECK ADD  CONSTRAINT [FK_Programacion_servicio] FOREIGN KEY([idservicio])
REFERENCES [dbo].[servicio] ([idservicio])
GO
ALTER TABLE [dbo].[Programacion] CHECK CONSTRAINT [FK_Programacion_servicio]
GO
/****** Object:  StoredProcedure [dbo].[pa_actualizar_historia]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_actualizar_historia]
@numhistoria int,@apepat varchar(30),
@apemat varchar(30), @nombres varchar(30),@fechanac date,@dni char(8),
@direccion varchar(50)
as
begin
update Historia set apepat=@apepat,apemat=@apemat,
nombres=@nombres, fechanac=@fechanac,
dni=@dni,
direccion=@direccion
where numhistoria=@numhistoria
end
GO
/****** Object:  StoredProcedure [dbo].[pa_actualizar_programacion]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_actualizar_programacion] @idprogramacion int, @idservicio int, @idresponsanble int,
@turno char(1),@dialun int,@diamar int,@diamie int,@diajue int,@diavie int,@diasab int,
@estado bit
as
begin
update Programacion set idservicio=@idservicio, idresposanble=@idresponsanble,
turno=@turno, dialun=@dialun, diamar=@diamar,diamie=@diamie ,diajue=@diajue,
diavier=@diavie,diasab=@diasab, estado=@estado where idprogramacion=@idprogramacion
end 

GO
/****** Object:  StoredProcedure [dbo].[pa_actualizar_programacion_2]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_actualizar_programacion_2]
@idprogramacion int,@idservicio int,@idresponsable int,
@turno char(1),
@dialun int,
@diamar int,
@diamie int,
@diajue int,
@diavie int,
@diasab int,
@estado bit
as
begin
update Programacion set idservicio=@idservicio, idresposanble=@idresponsable,
turno=@turno,dialun=@dialun,diamar=@diamar,diamie=@diamie,
diajue=@diajue,diavier=@diavie,
diasab=@diasab,estado=@estado
where idprogramacion=@idprogramacion
end

GO
/****** Object:  StoredProcedure [dbo].[pa_actualizar_responsable]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_actualizar_responsable] @idresponsable int,@descripcion varchar(50)
as
begin
update Responsable set descripcion=@descripcion where idresponsable=@idresponsable
end
GO
/****** Object:  StoredProcedure [dbo].[pa_actualizar_servicio]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_actualizar_servicio] @idservicio int,@descripcion varchar(50)
as
begin
update servicio set descripcion=@descripcion where idservicio=@idservicio
end
GO
/****** Object:  StoredProcedure [dbo].[pa_cambiar_estado_programacion]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_cambiar_estado_programacion] @idprogramacion int
as
begin
update Programacion set estado='I' where idprogramacion=@idprogramacion
end 

GO
/****** Object:  StoredProcedure [dbo].[pa_doctor_servicios]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_doctor_servicios] @idservicio int, @turno char(1)
as
begin
 select Responsable.* from Responsable join Programacion on Programacion.idprogramacion=Responsable.idresponsable where idservicio=@idservicio
 and turno=@turno
 end
GO
/****** Object:  StoredProcedure [dbo].[pa_eliminar_servicio]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_eliminar_servicio] @idservicio int
as begin
delete from servicio where idservicio=@idservicio
end 


GO
/****** Object:  StoredProcedure [dbo].[pa_insertar_cita]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE  procedure [dbo].[pa_insertar_cita] @idusuario int,@idhistoria int,
@fechanac date,@idprogramacion int
as
begin
insert into citas (idusuario,idhistoria,fecha,idprogramacion) values(@idusuario,@idhistoria,@fechanac,@idprogramacion)
end
GO
/****** Object:  StoredProcedure [dbo].[pa_insertar_historia]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertar_historia] @apepat varchar(30),
@apemat varchar(30), @nombres varchar(30),@fechanac date,@dni char(8),
@direccion varchar(50)
as
begin
insert into Historia (apepat,apemat,nombres,fechanac,dni,direccion) values(@apepat,@apemat,@nombres,@fechanac,
@dni,@direccion)

end
GO
/****** Object:  StoredProcedure [dbo].[pa_insertar_programacion]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertar_programacion] @idservicio int,@idresponsable int,@turno char(1),@dialun int,
@diamar int, @diamie int,@diajue int,@diabvie int,@diasab int,@estado bit
as
begin
insert into Programacion (idservicio,idresposanble,turno,dialun,diamar,diamie,diajue,diavier,diasab,estado)
values (@idservicio,@idresponsable,@turno,@dialun,@diamar,@diamie,@diajue,@diabvie,@diasab,@estado)
end
GO
/****** Object:  StoredProcedure [dbo].[pa_insertar_responsable]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertar_responsable] @responsable varchar(50)
as
begin
insert into Responsable (descripcion) values(@responsable)

end
GO
/****** Object:  StoredProcedure [dbo].[pa_insertar_servicio]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertar_servicio] @descripcion varchar(50)
as
begin
insert into servicio (descripcion) values(@descripcion)
end
GO
/****** Object:  StoredProcedure [dbo].[pa_listar_historias]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_listar_historias] 
as 
begin
select * from historia
end
GO
/****** Object:  StoredProcedure [dbo].[pa_listar_programacion]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_listar_programacion] @idservicio int,@turno char(1), @idresponsable int
as
begin
select *,Responsable.descripcion as responsable,servicio.descripcion as servicio from programacion
 join servicio on servicio.idservicio=Programacion.idservicio join Responsable on Programacion.idresposanble=Responsable.idresponsable
where programacion.idservicio=@idservicio and turno=@turno and Programacion.estado=1 and idresponsable=@idresponsable
end
GO
/****** Object:  StoredProcedure [dbo].[pa_listar_programacion_2]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_listar_programacion_2]
as
begin
select *,Responsable.descripcion as responsable,servicio.descripcion as servicio from programacion
 join servicio on servicio.idservicio=Programacion.idservicio join Responsable on Programacion.idresposanble=Responsable.idresponsable
 
end
GO
/****** Object:  StoredProcedure [dbo].[pa_listar_responsables]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_listar_responsables] 
as
begin 
select * from Responsable
end
GO
/****** Object:  StoredProcedure [dbo].[pa_listar_servicios]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_listar_servicios]
as
begin 
select * from servicio 
end

GO
/****** Object:  StoredProcedure [dbo].[pa_login]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_login] @sesion varchar(12), @password varchar(12)
as

begin
select * from Usuario where sesion=@sesion and contrasenia=@password
end
GO
/****** Object:  StoredProcedure [dbo].[pa_obtener_cita]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_obtener_cita] @idcita int
as
begin
select * , servicio.descripcion as servicio from citas join Programacion on Programacion.idprogramacion=citas.idprogramacion
join servicio on Programacion.idservicio=servicio.idservicio
join Historia on Historia.numhistoria=citas.idhistoria
 where idcita=@idcita
end
GO
/****** Object:  StoredProcedure [dbo].[pa_obtener_historia]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_obtener_historia] @idhistoria int
as
begin
select * from Historia where numhistoria=@idhistoria
end
GO
/****** Object:  StoredProcedure [dbo].[pa_obtener_historia_dni]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_obtener_historia_dni] @dni varchar(8) 
as
begin
select  * from Historia where dni like '%'+@dni +'%'
end 

GO
/****** Object:  StoredProcedure [dbo].[pa_obtener_historia_id]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_obtener_historia_id] @idhistoria int
as
begin
select  * from Historia where numhistoria=@idhistoria
end 

GO
/****** Object:  StoredProcedure [dbo].[pa_obtener_historia_nombre]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_obtener_historia_nombre] @apepat varchar(30) 
as
begin
select  * from Historia where apemat like '%'+apemat +'%'
end 

GO
/****** Object:  StoredProcedure [dbo].[pa_obtener_programacion]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_obtener_programacion] @idprogramacion int
as
begin
select * from Programacion where idprogramacion=@idprogramacion
end
GO
/****** Object:  StoredProcedure [dbo].[pa_obtener_responsable]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_obtener_responsable] @idresponsable int
as
begin
select * from Responsable where idresponsable=@idresponsable
end
GO
/****** Object:  StoredProcedure [dbo].[pa_obtener_servicio]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_obtener_servicio] @idservicio int
as
begin
select * from Servicio where idservicio=@idservicio
end
GO
/****** Object:  StoredProcedure [dbo].[pa_reporte]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_reporte] @idresponsable int
as
begin
select citas.* from Citas join Programacion on citas.idprogramacion=Programacion.idprogramacion
join Responsable on Programacion.idresposanble=Responsable.idresponsable where Responsable.idresponsable=@idresponsable
end 
GO
/****** Object:  StoredProcedure [dbo].[pa_servicio_turno]    Script Date: 01/12/2017 16:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE procedure [dbo].[pa_servicio_turno] @turno char(1)
 as
 begin
 select * from servicio join Programacion on servicio.idservicio=Programacion.idservicio where turno=@turno
 end
GO
