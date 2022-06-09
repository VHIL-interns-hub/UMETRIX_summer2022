from pdb import post_mortem
from urllib import request
from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from rest_framework.parsers import JSONParser
from rest_framework.decorators import api_view
from pprint import pprint
from django.http.response import JsonResponse
from snippetsApp.functions import *
from rest_framework.generics import  ListCreateAPIView, RetrieveUpdateDestroyAPIView
from django.http import HttpResponse

from snippetsApp.models import ReferenceTable
from snippetsApp.serializers import ReferenceTableSerializer
# Create your views here.

'''
@csrf_exempt
def referenceAPI(request, id=0):
    if request.method=='GET':
        references = ReferenceTable.objects.all()
        idd = self.request.query_params.get('id')
        reference_serializer = ReferenceTableSerializer(references, many=True)
        for x in references:
            print (x.snip_id[0])
        func("XXXXXX")
        #return JsonResponse()
        return JsonResponse(reference_serializer.data, safe = False)
    elif request.method=='POST':
        reference_data=JSONParser().parse(request)
        reference_serializer = ReferenceTableSerializer(data=reference_data)
        if reference_serializer.is_valid():
            reference_serializer.save()
            return JsonResponse("ADDED SUCCESSFULLY", safe=False)
        return JsonResponse("Failed to ADD", safe = False)
    elif request.method=='PUT':
        references_data=JSONParser().parse(request)
        reference = ReferenceTable.objects.get(Tag=references_data['Tag'])
        reference_serializer = ReferenceTableSerializer(reference, data=references_data)
        if reference_serializer.is_valid():
            reference_serializer.save()
            return JsonResponse("SUCCESS", safe=False)
        return JsonResponse("FAIL", safe=False)
    elif request.method=='DELETE':
        reference=ReferenceTable.objects.get(Tag=id)
        reference.delete()
        return JsonResponse("Deleted Successfully",safe=False)
    
# delete method at 16:13 https://www.youtube.com/watch?v=I17uA1sVQ2g&list=PLDA3fgkF3nR0VDXePfev0I1z_de7jeFvG&index=31


@api_view(['GET', 'POST', 'DELETE'])
def referenceAPI(request, tag):
    if request.method == 'GET':
        name = request.GET.get('tag')
        if not name:
            name = ""
        #reference = ReferenceTable.objects.get(Tag__icontains = name)
        lookup_field = 'slug'
        lookup_url_kwarg = 'Tag'
        reference_serializer = ReferenceTableSerializer
        return JsonResponse(reference_serializer.data)
    #try:
     #   reference = ReferenceTable.objects.get(Tag=tag)
    #except:
     #   return JsonResponse({'message':'Does not exist'})

'''
'''
# Working
class ReferenceTableView(RetrieveUpdateDestroyAPIView):
    queryset = ReferenceTable.objects.all()
    serializer_class = ReferenceTableSerializer
    if request == 'POST':
        if serializer_class.is_valid():
            serializer_class.save()
    lookup_field = 'Tag'
    lookup_url_kwarg = 'tag'
'''
'''
class ReferenceTableCreate(RetrieveUpdateDestroyAPIView):
    def get(self, request):
        return HttpResponse('result')

class ReferenceTableList(ListCreateAPIView):
    queryset = ReferenceTable.objects.all()
    serializer_class = ReferenceTableSerializer
    
'''

#class ReferenceTableView(APIView)


# working
@csrf_exempt
@api_view(['GET', 'POST', 'PUT', 'DELETE'])
#@ListCreateAPIView(['GET','PUT','POST'])
def inventory_item(request, Tag):
    param = Tag
    if request.method == 'GET':
        Temp = request.GET.get(param,' ')
        try:
            items = ReferenceTable.objects.filter(Tag__iexact=param)    # xyz = Blogs.objects.all().filter(user_id=id)
            serializer = ReferenceTableSerializer(items, many=True)
            return JsonResponse(serializer.data, safe =False)
        except ReferenceTable.DoesNotExist:
            return JsonResponse("FAIL")
    elif request.method=='POST':
        reference_data=JSONParser().parse(request)
        reference_serializer = ReferenceTableSerializer(data=reference_data)
        if reference_serializer.is_valid():
            reference_serializer.save()
            return JsonResponse("ADDED SUCCESSFULLY", safe=False)
        return JsonResponse("Failed to ADD", safe = False)
    elif request.method=='PUT':
        references_data=JSONParser().parse(request)
        reference = ReferenceTable.objects.get(Tag=references_data['Tag'])
        reference_serializer = ReferenceTableSerializer(reference, data=references_data)
        if reference_serializer.is_valid():
            reference_serializer.save()
            return JsonResponse("SUCCESS", safe=False)
        return JsonResponse("FAIL", safe=False)
    elif request.method=='DELETE':
        reference=ReferenceTable.objects.get(Tag=param)
        reference.delete()
        return JsonResponse("Deleted Successfully",safe=False)
    


'''reference_data=JSONParser().parse(request)
        reference_serializer = ReferenceTableSerializer(data=reference_data)
        if reference_serializer.is_valid():
            reference_serializer.save()
            return JsonResponse("ADDED SUCCESSFULLY", safe=False)'''