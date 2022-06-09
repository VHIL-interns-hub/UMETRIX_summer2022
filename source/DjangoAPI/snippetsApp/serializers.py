import imp
from django.forms import ModelChoiceField
from rest_framework import serializers
from snippetsApp.models import ReferenceTable
from rest_framework.serializers import ModelSerializer

'''
class CodeSnippetsSerializer(serializers.ModelSerializer):
    class Meta:
        model = CodeSnippets
        fields=('Snip')
        '''

class ReferenceTableSerializer(serializers.ModelSerializer):
    class Meta:
        model = ReferenceTable
        fields=['CodeSnippetID', 'Tag','Description','Code', 'OptChar','OptInt'] # add snip here
        #fields = '__all__'
        



