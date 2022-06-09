from django.urls import include, re_path as url
from snippetsApp import views

urlpatterns=[
    #url(r'^reference$',views.referenceAPI), # for GET method
    #url(r'^reference/POST$',views.ReferenceTableCreate.as_view()), # for GET method
    #url(r'^reference/(?P<tag>[\w-]+)/$',views.ReferenceTableView.as_view(), name='target'),     # Don't touch
    #url(r'^reference/OPT',views.ReferenceTableList.as_view())
    
    #url(r'^reference/(?P<slug>[\w-]+)/$',views.referenceAPI)
    url(r'^reference/(?P<Tag>[\w-]+)/$',views.inventory_item)
]