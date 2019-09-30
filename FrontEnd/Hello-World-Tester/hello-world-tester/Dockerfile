FROM node:11 as prepare
WORKDIR /home/node/app
COPY package.json .
#COPY yarn.lock .
RUN yarn install

FROM node:11 as builder
WORKDIR /home/node/app
COPY . .
COPY --from=prepare /home/node/app/node_modules node_modules
RUN yarn build

FROM bitnami/nginx:latest
ARG BACKEND_ENDPOINT
ARG BACKEND_PORT

COPY nginx/nginx.conf /opt/bitnami/nginx/conf/server_blocks/proxy_server_block.conf

RUN sed -i "s/\$BACKEND_ENDPOINT/${BACKEND_ENDPOINT}/g" /opt/bitnami/nginx/conf/server_blocks/proxy_server_block.conf && \
    sed -i "s/\$BACKEND_PORT/${BACKEND_PORT}/g" /opt/bitnami/nginx/conf/server_blocks/proxy_server_block.conf

COPY --from=builder /home/node/app/build/ /usr/share/nginx/html
#COPY --from=builder /home/node/app/.env.development /usr/share/nginx

 #CMD ["npm", "start"]
