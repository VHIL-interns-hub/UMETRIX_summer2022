from django.urls import include, re_path as url
from snippetsApp import views

urlpatterns=[
    url(r'^reference$',views.referenceAPI), # for GET method
    url(r'^reference/([A-z]+)$',views.referenceAPI)
    #url(r'^reference/(?P<slug>[\w-]+)/$',views.referenceAPI)
]