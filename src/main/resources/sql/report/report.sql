CREATE SEQUENCE SEQ_REPORT;

CREATE TABLE TBL_REPORT(
                           ID NUMBER CONSTRAINT PK_TBL_REPORT PRIMARY KEY,
                           POST_ID NUMBER NOT NULL,
                           USER_ID NUMBER NOT NULL,
                           REPORT_REASON VARCHAR2(255) NOT NULL,
                           REPORT_STATUS NUMBER NOT NULL,
                           CONSTRAINT FK_REPORT_POST FOREIGN KEY(POST_ID)
                               REFERENCES TBL_POST(ID),
                           CONSTRAINT FK_REPORT_USER FOREIGN KEY(USER_ID)
                               REFERENCES TBL_USER(ID)
);

SELECT *FROM TBL_REPORT;

DROP TABLE TBL_REPORT;