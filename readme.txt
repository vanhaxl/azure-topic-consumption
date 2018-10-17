{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf600
{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;\red255\green255\blue254;\red144\green1\blue18;
\red9\green60\blue148;\red0\green0\blue255;\red19\green120\blue72;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;\cssrgb\c100000\c100000\c99608;\cssrgb\c63922\c8235\c8235;
\cssrgb\c1569\c31765\c64706;\cssrgb\c0\c0\c100000;\cssrgb\c3529\c53333\c35294;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 - Create a collection \'93topic\'94 on Azure Cosmos DB.\
- Create a service bus \'93bus-vhnguyen\'94 \
- Create 2 topic named \'93topic-movie\'94 and \'93topic-music\'94 \
- For each above topic, create 2 subscription \'93subscription-basic\'94 and \'93subscription-premium\'94\
- Create a function app to trigger, listen to the \'93topic\'94 collection, out is a topic. So we need to create 2 function apps.\
\
Data for the topic collection\
\pard\pardeftab720\sl360\partightenfactor0

\f1 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \{\cb1 \
\cb3     \cf4 \strokec4 "id"\cf2 \strokec2 : \cf5 \strokec5 "1"\cf2 \strokec2 ,\cb1 \
\cb3     \cf4 \strokec4 "name"\cf2 \strokec2 : \cf5 \strokec5 "Avengers"\cf2 \strokec2 ,\cb1 \
\cb3     \cf4 \strokec4 "filetype"\cf2 \strokec2 : \cf5 \strokec5 "movie"\cf2 \strokec2 \
\}\
\
Trigger function. Used Javascript.\
Function for movie\
\pard\pardeftab720\sl340\partightenfactor0
\cf6 \strokec6 module\cf2 \strokec2 .exports = \cf6 \strokec6 function\cf2 \strokec2  (context, documents) \{\cb1 \
\cb3     \cf6 \strokec6 var\cf2 \strokec2  filetype = documents[\cf7 \strokec7 0\cf2 \strokec2 ].filetype;\cb1 \
\cb3     \cf6 \strokec6 if\cf2 \strokec2 (filetype === \cf4 \strokec4 "movie"\cf2 \strokec2 )\{\cb1 \
\cb3         context.bindings.outputMessage = JSON.stringify(\{\cb1 \
\cb3             id: documents[\cf7 \strokec7 0\cf2 \strokec2 ].id,\cb1 \
\cb3             name: documents[\cf7 \strokec7 0\cf2 \strokec2 ].name,\cb1 \
\cb3             filetype: documents[\cf7 \strokec7 0\cf2 \strokec2 ].filetype\cb1 \
\cb3         \});\cb1 \
\cb3     \}\cb1 \
\cb3     context.done();\cb1 \
\cb3 \}\
\
Function for music:\
\cf6 \strokec6 module\cf2 \strokec2 .exports = \cf6 \strokec6 function\cf2 \strokec2  (context, documents) \{\cb1 \
\cb3     \cf6 \strokec6 var\cf2 \strokec2  filetype = documents[\cf7 \strokec7 0\cf2 \strokec2 ].filetype;\cb1 \
\cb3     \cf6 \strokec6 if\cf2 \strokec2 (filetype === \cf4 \strokec4 "music"\cf2 \strokec2 )\{\cb1 \
\cb3         context.bindings.outputMessage = JSON.stringify(\{\cb1 \
\cb3             id: documents[\cf7 \strokec7 0\cf2 \strokec2 ].id,\cb1 \
\cb3             name: documents[\cf7 \strokec7 0\cf2 \strokec2 ].name,\cb1 \
\cb3             filetype: documents[\cf7 \strokec7 0\cf2 \strokec2 ].filetype\cb1 \
\cb3         \});\cb1 \
\cb3     \}\cb1 \
\cb3     context.done();\cb1 \
\cb3 \}\cb1 \
\
- Download the spring application, modify .properties file if necessary.\
- Run.\
\pard\pardeftab720\sl360\partightenfactor0
\cf2 \
}