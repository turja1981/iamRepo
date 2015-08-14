

CREATE  TABLE T_USER(
USER_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(50),
MOBILENO VARCHAR(20),
EMAIL VARCHAR(100),
GENDER VARCHAR(10),
AGE INTEGER,
PROFESSION VARCHAR(50),
EXPERIENCE INTEGER ,
PROFILE VARCHAR(100),
STATUS VARCHAR(20) ,
CREATED_BY VARCHAR(20),
CREATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
UPDATED_BY VARCHAR(20),
UPDATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP );


CREATE  TABLE T_ADDRESS(
ADRS_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
USER_ID INTEGER ,
CITY VARCHAR(50),
LOCALITY VARCHAR(50),
ZIP VARCHAR(20),
COUNTRY VARCHAR(50),
CREATED_BY VARCHAR(20),
CREATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
UPDATED_BY VARCHAR(20),
UPDATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (USER_ID) 
        REFERENCES T_USER(USER_ID)
        ON DELETE CASCADE
);

CREATE  TABLE T_JOBQ(
JOB_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
JOB_DESC VARCHAR(100),
REQ_USER_ID  INTEGER,
REQUIRED_TIME TIMESTAMP ,
END_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
STATUS VARCHAR(30),
URGENCY  VARCHAR(10) ,
CREATED_BY VARCHAR(20),
CREATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
UPDATED_BY VARCHAR(20),
UPDATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE  TABLE T_JOB_RESPONSE(
RES_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
JOB_ID INTEGER  ,
RES_USER_ID  INTEGER,
STATUS VARCHAR(30),
CREATED_BY VARCHAR(20),
CREATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
UPDATED_BY VARCHAR(20),
UPDATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (JOB_ID) 
        REFERENCES T_JOBQ(JOB_ID)
        ON DELETE CASCADE
);

CREATE  TABLE T_MESSAGE(
MSG_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
SRC_USER_ID INTEGER,
DEST_USER_ID INTEGER,
STATUS VARCHAR(30),
MSG_TYPE VARCHAR(30),
START_TIME TIMESTAMP ,
CREATED_BY VARCHAR(20),
CREATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
UPDATED_BY VARCHAR(20),
UPDATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE  TABLE T_RATING(
RATING_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
RATING_LEVEL VARCHAR(20),
SP_USER_ID INTEGER,
CON_USER_ID INTEGER,
CREATED_BY VARCHAR(20),
CREATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
UPDATED_BY VARCHAR(20),
UPDATED_ON   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

