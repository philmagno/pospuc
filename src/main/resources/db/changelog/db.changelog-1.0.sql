--liquibase formatted sql

--changeset philippe:1
CREATE TABLE IF NOT EXISTS usuario (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `senha` VARCHAR(500) NULL,
  `data_nascimento` DATE NULL,
  `nome` VARCHAR(255) NULL,
  `cpf` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `ultimo_acesso` DATETIME NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
--rollback drop usuario;

--changeset philippe:2
CREATE TABLE IF NOT EXISTS aluno (
  `id` INT NOT NULL AUTO_INCREMENT,
  `RA` VARCHAR(45) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_aluno_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `faculdade`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
--rollback drop aluno;

--changeset philippe:3
CREATE TABLE IF NOT EXISTS materia (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NULL,
  `carga_horaria` INT NULL,
  `tipo_aula` VARCHAR(100) NULL,
  `periodo` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
--rollback drop materia;

--changeset philippe:4
CREATE TABLE IF NOT EXISTS `faculdade`.`curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `curriculo_id` INT NOT NULL,
  `modalidade` VARCHAR(45) NULL,
  `duracao` VARCHAR(45) NULL,
  `tipo_formacao` VARCHAR(45) NULL,
  `valor` DECIMAL NULL,
  `coordenador_id` INT NOT NULL,
  `data_oferta` VARCHAR(45) NULL,
  `horas_complementares` VARCHAR(45) NULL,
  `campus` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_curso_usuario1_idx` (`coordenador_id` ASC) ,
  CONSTRAINT `fk_curso_usuario1`
    FOREIGN KEY (`coordenador_id`)
    REFERENCES `faculdade`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


--changeset philippe:5
CREATE TABLE IF NOT EXISTS `faculdade`.`grade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `materia_id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_grade_materia1_idx` (`materia_id` ASC) ,
  INDEX `fk_grade_curso1_idx` (`curso_id` ASC) ,
  CONSTRAINT `fk_grade_materia1`
    FOREIGN KEY (`materia_id`)
    REFERENCES `faculdade`.`materia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grade_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `faculdade`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


--changeset philippe:6
CREATE TABLE IF NOT EXISTS `faculdade`.`turma` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade_alunos` VARCHAR(45) NULL,
  `max_alunos` INT NULL,
  `min_alunos` INT NULL,
  `curso_id` INT NOT NULL,
  `materia_id` INT NOT NULL,
  `data_oferta` DATE NULL,
  `status` VARCHAR(45) NULL,
  `professor_materia_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_turma_curso1_idx` (`curso_id` ASC) ,
  INDEX `fk_turma_materia1_idx` (`materia_id` ASC),
  INDEX `fk_turma_usuario1_idx` (`professor_materia_id` ASC) ,
  CONSTRAINT `fk_turma_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `faculdade`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_materia1`
    FOREIGN KEY (`materia_id`)
    REFERENCES `faculdade`.`materia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_usuario1`
    FOREIGN KEY (`professor_materia_id`)
    REFERENCES `faculdade`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


--changeset philippe:7
CREATE TABLE IF NOT EXISTS `faculdade`.`matricula` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `turma_id` INT NOT NULL,
  `aluno_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_matricula_turma1`
    FOREIGN KEY (`turma_id`)
    REFERENCES `faculdade`.`turma` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `faculdade`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


--changeset philippe:8
CREATE TABLE IF NOT EXISTS `faculdade`.`mensalidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `aluno_id` INT NOT NULL,
  `data_vencimento` DATE NOT NULL,
  `data_pagamento` DATE NULL,
  `numero_mensalidade` INT NULL,
  `tipo_pagamento` VARCHAR(100) NULL,
  `curso_id` INT NOT NULL,
  `valor_pago` DECIMAL NULL,
  `mensalidadecol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `aluno_id`),
  CONSTRAINT `fk_mensalidade_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `faculdade`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `faculdade`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;