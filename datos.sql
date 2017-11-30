USE [jct3]
GO
INSERT [dbo].[Usuario] ([idusuario], [sesion], [contrasenia], [tipo_usuario]) VALUES (1, N'admin', N'admin', N'1')
SET IDENTITY_INSERT [dbo].[Historia] ON 

INSERT [dbo].[Historia] ([numhistoria], [apepat], [apemat], [nombres], [fechanac], [dni], [direccion]) VALUES (1, N'aaa', N'bl', N'lll', CAST(N'2017-10-10' AS Date), N'1234118 ', N'dsdaf')
INSERT [dbo].[Historia] ([numhistoria], [apepat], [apemat], [nombres], [fechanac], [dni], [direccion]) VALUES (2, N'vasquez', N'bl', N'lll', CAST(N'2017-10-10' AS Date), N'12345678', N'dsdaf')
INSERT [dbo].[Historia] ([numhistoria], [apepat], [apemat], [nombres], [fechanac], [dni], [direccion]) VALUES (3, N'vasquez', N'ssss', N'le', CAST(N'1999-07-26' AS Date), N'45454545', N'kfjnodfhd')
SET IDENTITY_INSERT [dbo].[Historia] OFF
SET IDENTITY_INSERT [dbo].[servicio] ON 

INSERT [dbo].[servicio] ([idservicio], [descripcion]) VALUES (1, N'actulia')
INSERT [dbo].[servicio] ([idservicio], [descripcion]) VALUES (2, N'Servicio 2')
INSERT [dbo].[servicio] ([idservicio], [descripcion]) VALUES (3, N'descripiones')
INSERT [dbo].[servicio] ([idservicio], [descripcion]) VALUES (4, N'actuliacdd')
INSERT [dbo].[servicio] ([idservicio], [descripcion]) VALUES (5, N'actulia')
INSERT [dbo].[servicio] ([idservicio], [descripcion]) VALUES (6, N'mmmm')
SET IDENTITY_INSERT [dbo].[servicio] OFF
SET IDENTITY_INSERT [dbo].[Responsable] ON 

INSERT [dbo].[Responsable] ([idresponsable], [descripcion]) VALUES (1, N'leo')
INSERT [dbo].[Responsable] ([idresponsable], [descripcion]) VALUES (2, N'vpppaaaa')
SET IDENTITY_INSERT [dbo].[Responsable] OFF
SET IDENTITY_INSERT [dbo].[Programacion] ON 

INSERT [dbo].[Programacion] ([idprogramacion], [idservicio], [idresposanble], [turno], [dialun], [diamar], [diamie], [diajue], [diavier], [diasab], [estado]) VALUES (1, 3, 2, N'm', 8, 8, 7, 6, 5, 4, 0)
INSERT [dbo].[Programacion] ([idprogramacion], [idservicio], [idresposanble], [turno], [dialun], [diamar], [diamie], [diajue], [diavier], [diasab], [estado]) VALUES (2, 2, 1, N'm', 8, 8, 7, 6, 5, 4, 1)
INSERT [dbo].[Programacion] ([idprogramacion], [idservicio], [idresposanble], [turno], [dialun], [diamar], [diamie], [diajue], [diavier], [diasab], [estado]) VALUES (3, 1, 1, N'm', 8, 8, 7, 6, 5, 4, 0)
SET IDENTITY_INSERT [dbo].[Programacion] OFF
SET IDENTITY_INSERT [dbo].[Citas] ON 

INSERT [dbo].[Citas] ([idcita], [idusuario], [idhistoria], [fecha], [idprogramacion]) VALUES (1, 1, 2, CAST(N'2017-10-11' AS Date), 2)
INSERT [dbo].[Citas] ([idcita], [idusuario], [idhistoria], [fecha], [idprogramacion]) VALUES (2, 1, 2, CAST(N'2017-10-11' AS Date), 2)
SET IDENTITY_INSERT [dbo].[Citas] OFF
